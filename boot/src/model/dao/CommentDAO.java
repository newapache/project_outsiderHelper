package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.AnonymousDTO;
import model.CommentDTO;

public class CommentDAO{
	private JDBCUtil jdbcUtil = null;
	  
	   public CommentDAO() {         
	      jdbcUtil = new JDBCUtil();   
	   }
	   
	   public int create(CommentDTO comm)
	   {
	      String sql = "INSERT INTO COMMENTS VALUES(CNUM.nextval, ?, ?, ?, SYSDATE)";
	      
	         Object[] param = new Object[] {
	        		 comm.getContent(),
	        		 comm.getUserID(),
	        		 comm.getBoardID()
	         };          
	         jdbcUtil.setSqlAndParameters(sql, param); 
	         
	      try {            
	         int result = jdbcUtil.executeUpdate();   // 
	         return result;
	         
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      } finally {      
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 諛섑솚
	      }      
	      return 0;   
	   }
	   
	   public int delete(String commentId) {
		      // TODO Auto-generated method stub
		      String sql = "DELETE FROM COMMENTS WHERE COMMENTID=?";      
		      
		      jdbcUtil.setSqlAndParameters(sql, new Object[] {commentId});
		      try {            
		         int result = jdbcUtil.executeUpdate();   // delete �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
		         return result;
		      } catch (Exception ex) {
		         jdbcUtil.rollback();
		         ex.printStackTrace();
		      }
		      finally {
		         jdbcUtil.commit();
		         jdbcUtil.close();   // resource �뜝�룞�삕�솚
		      }      
		      return 0;
		   }
	   
	   public int update(CommentDTO comm, int commentId){
		      String sql = "UPDATE COMMNETS "
		               + "SET CONTENT=? "
		               + "WHERE COMMENTID=?";
		      Object[] param = new Object[] {comm.getContent()};
		      jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil�뜝�룞�삕 update�뜝�룞�삕�뜝�룞�삕 �뜝�떊怨ㅼ삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
		         
		      try {            
		         int result = jdbcUtil.executeUpdate();   // update �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
		         return result;
		      } catch (Exception ex) {
		         jdbcUtil.rollback();
		         ex.printStackTrace();
		      }
		      finally {
		         jdbcUtil.commit();
		         jdbcUtil.close();   // resource �뜝�룞�삕�솚
		      }      
		      return 0;
		   }
	   
	   public ArrayList<CommentDTO> getList(int boardID) {
	      String sql = "SELECT * FROM COMMENTS WHERE BOARDID=?";
	      jdbcUtil.setSqlAndParameters(sql, new Object[] {boardID});         
	      
	      try {
	    	  
	    	  	ResultSet rs = jdbcUtil.executeQuery();            // query �떎�뻾         
	            ArrayList<CommentDTO> CommList = new ArrayList<CommentDTO>();   // aboard�뱾�쓽 由ъ뒪�듃 �깮�꽦
	            while(rs.next()) {
	               java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	               java.util.Date utilDate = new java.util.Date(rs.getDate("writeTime").getTime());
	               String dateString = df.format(utilDate);
	               
	               CommentDTO comm = new CommentDTO(      // aboard 媛앹껜瑜� �깮�꽦�븯�뿬 �쁽�옱 �뻾�쓽 �젙蹂대�� ���옣
	            		   rs.getInt("commentID"),
	            		   rs.getString("content"),
	            		   rs.getString("userID"),
	            		   rs.getInt("boardID"),
	            		   dateString);
	               
	               CommList.add(comm);                     // 由ъ뒪�듃�뿉 aboard 媛앹껜 ���옣
	            };
	            return CommList;                     
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();      // resource 諛섑솚
	      }
	      return null;
	   }
}