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


public class AnonymousDAO {
   
private JDBCUtil jdbcUtil = null;
   
   public AnonymousDAO() {         
      jdbcUtil = new JDBCUtil();   
   }

   // 삽입
   public int create(AnonymousDTO aboard)
   {
      String sql = "INSERT INTO ANONYMOUS_BOARD VALUES(BOARDNUM.nextval, ?, ?, ?, ?, SYSDATE, ?)";
      
         Object[] param = new Object[] {
               aboard.getCategory(), 
               aboard.getTitle(), 
               aboard.getContent(),
               0,//aboard.getUserID(),
               0};             
         jdbcUtil.setSqlAndParameters(sql, param); 
         
      try {            
         int result = jdbcUtil.executeUpdate();   // insert 문 실행
         return result;
         
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }      
      return 0;   
   }
   // 삭제
   public int delete(String aboardId) {
      // TODO Auto-generated method stub
      String sql = "DELETE FROM ANONYMOUS_BOARD WHERE ABOARDID=?";      
      
      jdbcUtil.setSqlAndParameters(sql, new Object[] {aboardId});
      try {            
         int result = jdbcUtil.executeUpdate();   // delete 占쏙옙 占쏙옙占쏙옙
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 占쏙옙환
      }      
      return 0;
   }
   // 수정
   public int update(AnonymousDTO aboard, int aboardId){
      String sql = "UPDATE ANONYMOUS_BOARD "
               + "SET CATEGORY=?, TITLE=?, CONTENT=? "
               + "WHERE ABOARDID=?";
      Object[] param = new Object[] {
            aboard.getCategory(),
            aboard.getTitle(),
            aboard.getContent(),
            aboardId};            
      jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil占쏙옙 update占쏙옙占쏙옙 占신곤옙 占쏙옙占쏙옙 占쏙옙占쏙옙
         
      try {            
         int result = jdbcUtil.executeUpdate();   // update 占쏙옙 占쏙옙占쏙옙
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 占쏙옙환
      }      
      return 0;
   }
   // 검색
   public ArrayList<AnonymousDTO> search(String category, String search)
   {
      String sql = null;
      Object[] param = null;
      if(search.equals("") && category.equals("전체")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD ORDER BY ABOARDID DESC";
         param = new Object[] {};
      }
      else if(search.equals("") && category.equals("잡담")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE CATEGORY=? ORDER BY ABOARDID DESC";
         param = new Object[] {category};
      }
      else if(search.equals("") && category.equals("고민")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE CATEGORY=? ORDER BY ABOARDID DESC";
         param = new Object[] {category};
      }
      else if(search.equals("") && category.equals("팀플")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE CATEGORY=? ORDER BY ABOARDID DESC";
         param = new Object[] {category};
      }
      else if(category.equals("전체")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%' ORDER BY ABOARDID DESC";
         param = new Object[] {search, search};
      }
      else if(category.equals("잡담")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE (TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%') AND CATEGORY='?' ORDER BY ABOARDID DESC";
         param = new Object[] {search, search, category};
      }
      else if(category.equals("고민")) {
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE (TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%') AND CATEGORY='?' ORDER BY ABOARDID DESC";
         param = new Object[] {search, search, category};
      }
      else if(category.equals("팀플")){
         sql = "SELECT * FROM ANONYMOUS_BOARD WHERE (TITLE LIKE '%'||?||'%' OR CONTENT LIKE '%'||?||'%') AND CATEGORY='?' ORDER BY ABOARDID DESC";
         param = new Object[] {search, search, category};
      }
      jdbcUtil.setSqlAndParameters(sql, param);
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         //int start = ((currentPage-1) * countPerPage) + 1;
         //if ((start >= 0) && rs.absolute(start)) {
            ArrayList<AnonymousDTO> AboardList = new ArrayList<AnonymousDTO>();   // User占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙
         while(rs.next()) {
            //do{
            java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = new java.util.Date(rs.getDate("writeTime").getTime());
            String dateString = df.format(utilDate);
            AnonymousDTO aboard = new AnonymousDTO(      // aboard 객체를 생성하여 현재 행의 정보를 저장
                  rs.getInt("aboardID"),
                  rs.getString("category"),
                  rs.getString("title"),
                  rs.getString("content"),
                  rs.getInt("userID"),
                  dateString,
                  rs.getInt("readCount")
               );
            AboardList.add(aboard);
         }//while((rs.next()) && (--countPerPage > 0)); 
         return AboardList;
         //}
      }catch (Exception e){
         e.printStackTrace();
      }finally {
         jdbcUtil.close();
      }
      return null;
   }
   // 조회수
   public int readCount(String aboardID) {

      String sql = "UPDATE ANONYMOUS_BOARD SET readCount = readCount + 1 WHERE ABOARDID = ?";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {aboardID});
      try {            
         int result = jdbcUtil.executeUpdate();   // delete 占쏙옙 占쏙옙占쏙옙
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 占쏙옙환
      }      
      return 0;
      

   }
   // 게시글 페이지 출력
   public ArrayList<AnonymousDTO> getList(int currentPage, int countPerPage) {

       //String sql = "SELECT * FROM ANONYMOUS_BOARD ORDER BY ABOARDID DESC";
      String sql = "SELECT * FROM ANONYMOUS_BOARD ORDER BY ABOARDID DESC";
      jdbcUtil.setSqlAndParameters(sql, null,               // JDBCUtil에 query문 설정
            ResultSet.TYPE_SCROLL_INSENSITIVE,            // cursor scroll 가능
            ResultSet.CONCUR_READ_ONLY);                  
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();            // query 실행         
         int start = ((currentPage-1) * countPerPage) + 1;   // 출력을 시작할 행 번호 계산
         
         if ((start >= 0) && rs.absolute(start)) {         // 커서를 시작 행으로 이동
            ArrayList<AnonymousDTO> AboardList = new ArrayList<AnonymousDTO>();   // aboard들의 리스트 생성
            do {
               java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
               java.util.Date utilDate = new java.util.Date(rs.getDate("writeTime").getTime());
               String dateString = df.format(utilDate);
               
               AnonymousDTO aboard = new AnonymousDTO(      // aboard 객체를 생성하여 현재 행의 정보를 저장
                     rs.getInt("aboardID"),
                     rs.getString("category"),
                     rs.getString("title"),
                     rs.getString("content"),
                     rs.getInt("userID"),
                     dateString,
                     rs.getInt("readCount")
                  );
               
               AboardList.add(aboard);                     // 리스트에 aboard 객체 저장
            } while (rs.next() && (--countPerPage > 0));//while (rs.next());
            //while (rs.next() && (--countPerPage>0));
            return AboardList;                     
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      // resource 반환
      }
      return null;

   }
   // 게시글 번호에 해당하는 게시글
   public AnonymousDTO findAboard(String aboardId) throws SQLException {
        String sql = "SELECT * FROM ANONYMOUS_BOARD WHERE ABOARDID=? ";              
      jdbcUtil.setSqlAndParameters(sql, new Object[] {aboardId});   // JDBCUtil에 query문과 매개 변수 설정

      try {
         ResultSet rs = jdbcUtil.executeQuery();   // query 실행
         
         if (rs.next()) {         
            java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = new java.util.Date(rs.getDate("writeTime").getTime());
            String dateString = df.format(utilDate);
            // 학생 정보 발견
               AnonymousDTO aboard = new AnonymousDTO(      // User 객체를 생성하여 학생 정보를 저장   
               rs.getInt("aboardID"),
               rs.getString("category"),
               rs.getString("title"),
               rs.getString("content"),
               rs.getInt("userID"),
               dateString,
               rs.getInt("readCount")
               );
            return aboard;
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      // resource 반환
      }
      return null;
   }
   
   public int countAboard() throws SQLException
   {
      int count = 0;
      String sql = "SELECT COUNT(*) FROM ANONYMOUS_BOARD";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {});
      try {
      ResultSet rs = jdbcUtil.executeQuery();
      if(rs.next())
         count =  rs.getInt(1);
      }catch (Exception e) {
         e.printStackTrace();
      }
      return count;
   }
   
}