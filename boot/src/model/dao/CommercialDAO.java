package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.CommercialDTO;

public class CommercialDAO {
   
   private JDBCUtil jdbcUtil = null;
   int tempId= 225;
   
   public CommercialDAO() {
      jdbcUtil = new JDBCUtil();
   }
   
   //create
   public int create(CommercialDTO commercialDTO) {
      
      String query = "INSERT INTO COMMERCIAL_BOARD VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
      System.out.println("*****COMMERCIAL_DAO_CREATE: ");
      
      Object[] param = new Object[] {tempId, 1, commercialDTO.getCommercialName(), commercialDTO.getCommercialCategory(), 
            commercialDTO.getHasWifi(), commercialDTO.getHasSingleTable(), commercialDTO.getHasSocket(), 
            commercialDTO.getCongestion(), commercialDTO.getPrice(), commercialDTO.getGrade(),
            commercialDTO.getContent(), 0};
      /*Object[] param = new Object[] {
            tempId, commercialDTO.getPrice(), commercialDTO.getCongestion(), commercialDTO.getHasSingleTable(), commercialDTO.getHasWifi(), 1, 
            commercialDTO.getTitle(), commercialDTO.getContent(), commercialDTO.getLikeCount(), 
            commercialDTO.getCommercialName(), commercialDTO.getCommercialCategory(), commercialDTO.getHasSocket(), commercialDTO.getTotalScore()
      };*/
      
      System.out.println("wifi: " + commercialDTO.getHasWifi() +  "price: " + commercialDTO.getPrice() + " grade: " + commercialDTO.getGrade());
      
      jdbcUtil.setSqlAndParameters(query, param);
      
      try {
         int result = jdbcUtil.executeUpdate(); //insert commercialBoard object
         return result;
      } catch (Exception e) {
         jdbcUtil.rollback();
         e.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      
      return 0;
   }
   //read
   public ArrayList<CommercialDTO> read(int currentPage, int countPerPage) {
      
      //change ORDER BY WRITETIME
      String query = "SELECT * FROM COMMERCIAL_BOARD ORDER BY CBOARDID DESC";
      jdbcUtil.setSqlAndParameters(query, null, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      System.out.println(query);
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         int start = ((currentPage - 1) * countPerPage) + 1;
         
         if ((start >= 0) && rs.absolute(start)) {
            ArrayList<CommercialDTO> commercialList = new ArrayList<CommercialDTO>();
            do {
            	

                System.out.println("congestion: " + rs.getString("CONGESTION"));
                System.out.println("price: " + rs.getString("PRICE"));
                System.out.println("grade: " + rs.getString("GRADE"));
            	
               CommercialDTO commercial = new CommercialDTO(
                     rs.getInt("CBOARDID"), rs.getInt("USERID"), rs.getString("COMMERCIALNAME"), rs.getString("COMMERCIALCATEGORY"),
                     rs.getString("HASWIFI"), rs.getString("HASSINGLETABLE"), rs.getString("HASSOCKET"), 
                     rs.getString("CONGESTION"), 
                     rs.getString("PRICE"), rs.getString("GRADE"),
                     rs.getString("CONTENT"), rs.getInt("LIKECOUNT"));
               commercialList.add(commercial);
            } while ((rs.next()) && (--countPerPage > 0));
            return commercialList;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         jdbcUtil.close();
      }
      
      return null;
   }
   //search
   public CommercialDTO search(String commercialId) {
      
      String query = "SELECT * FROM COMMERCIAL_BOARD WHERE CBOARDID = ?";
      
      System.out.println("*****COMMERCIAL_DAO_SEARCH: ");
      
      jdbcUtil.setSqlAndParameters(query, new Object[] {commercialId});
      
      try {
         ResultSet rs = jdbcUtil.executeQuery();
         if (rs.next()) {
            CommercialDTO commercial = new CommercialDTO(rs.getInt("CBOARDID"), rs.getInt("USERID"),
                  rs.getString("COMMERCIALNAME"), rs.getString("COMMERCIALCATEGORY"),
                  rs.getString("HASWIFI"), rs.getString("HASSINGLETABLE"), rs.getString("HASSOCKET"), 
                  rs.getString("CONGESTION"), rs.getString("PRICE"), rs.getString("GRADE"),
                  rs.getString("CONTENT"), rs.getInt("LIKECOUNT"));
            
            System.out.println("*****COMMERCIAL_DAO_SEARCH: " + commercial.getCBoardId());
            return commercial;
         }
      } catch (Exception e) {
         System.out.println("*****COMMERCIAL_DAO_SERACH_FAILED");
         e.printStackTrace();
         return null;
      } finally {
         jdbcUtil.close();
      }
      return null;
   }
   //update
   public int update(CommercialDTO commercial, int cBoardId) {
	   
	  System.out.println("****COMMERCIAL_DAO_UPDATE:");
      
      String query = "UPDATE COMMERCIAL_BOARD "
            + "SET COMMERCIALNAME = ?, COMMERCIALCATEGORY = ?, "
            + "HASWIFI = ?, HASSINGLETABLE = ?, HASSOCKET = ?, "
            + "CONGESTION = ?, PRICE = ?, GRADE = ?, "
            + "CONTENT = ? "
            + "WHERE CBOARDID = ?";
      
      System.out.println(query);
      
      Object[] param = new Object[] {
            commercial.getCommercialName(), commercial.getCommercialCategory(),
            commercial.getHasWifi(), commercial.getHasSingleTable(), commercial.getHasSocket(), 
            commercial.getCongestion(), commercial.getPrice(), commercial.getGrade(),
            commercial.getContent(), cBoardId
      };
      jdbcUtil.setSqlAndParameters(query, param);
      
      try {            
         int result = jdbcUtil.executeUpdate();
         return result;
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      }
      finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }      
      return 0;
   }
   //delete
   public int delete(String commercialId) {
      String query = "DELETE FROM COMMERCIAL_BOARD WHERE CBOARDID = ?";
      
      jdbcUtil.setSqlAndParameters(query, new Object[] {commercialId});
      try {
         int result = jdbcUtil.executeUpdate();
         return result;
      } catch (Exception e) {
         jdbcUtil.rollback();
         e.printStackTrace();
      } finally {
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      
      return 0;
   }
   //like
   public int like(String cBoardId) {
	   
	   String query =  "UPDATE COMMERCIAL_BOARD SET LIKECOUNT = LIKECOUNT + 1 WHERE CBOARDID = ?";
	   
	 jdbcUtil.setSqlAndParameters(query,  new Object[] {cBoardId});
	 try {
		 int result = jdbcUtil.executeUpdate();
		 return result;
	 } catch (Exception e) {
		 jdbcUtil.rollback();
		 e.printStackTrace();
	 } finally {
		 jdbcUtil.commit();
		 jdbcUtil.close();
	 }
	 
	 return 0;
   }
   //filter
   public ArrayList<CommercialDTO> filter(String commercialName, String commercialCategory, 
		   String hasWifi, String hasSingleTable, String hasSocket,
		   String congestion, String price,
		   int currentPage, int countPerPage) {
	   
	   System.out.println("*****COMMERCIAL_DAO: FILTER");
	   System.out.println(commercialName + "::" + commercialCategory);
	   System.out.println(hasWifi + "::" + hasSingleTable + "::" + hasSocket);
	   System.out.println(congestion + "::" + price);
	   
	   String query = "SELECT * FROM COMMERCIAL_BOARD WHERE COMMERCIALCATEGORY = ?";
	   ArrayList<Object> param = new ArrayList<Object>();
	   param.add(commercialCategory);
	   
	   System.out.println();
	   
	   if (commercialName != "") {
		   query += " AND COMMERCIALNAME = ?";
		   param.add(commercialName);
	   }System.out.println(query);
	   if (hasWifi != "") {
		   query += " AND HASWIFI = ?";
		   param.add(hasWifi);
	   }System.out.println(query);
	   if (hasSingleTable != "") {
		   query += " AND HASSINGLETABLE = ?";
		   param.add("hasSingleTable");
	   }System.out.println(query);
	   if (hasSocket != "") {
		   query += " AND HASSOCKET = ?";
		   param.add(hasSocket);
	   }System.out.println(query);
	   if (congestion != "") {
		   query += " AND CONGESTION = ?";
		   param.add(congestion);
	   }System.out.println(query);
	   if (price != "") {
		   query += " AND PRICE = ?";
		   param.add(price);
	   }System.out.println(query);
	   
	   System.out.println(query);
	   
	   Object[] params = param.toArray();
	   jdbcUtil.setSqlAndParameters(query,  params, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	   
	   try {
		   ResultSet rs = jdbcUtil.executeQuery();
		   int start = ((currentPage - 1) * countPerPage) + 1;
		   
		   if ((start >= 0) && rs.absolute(start)) {
			   ArrayList<CommercialDTO> cBoards = new ArrayList<CommercialDTO>();
			   do {
				   CommercialDTO cBoard = new CommercialDTO(
						   rs.getInt("CBOARDID"), rs.getInt("USERID"), rs.getString("COMMERCIALNAME"), rs.getString("COMMERCIALCATEGORY"),
						   rs.getString("HASWIFI"), rs.getString("HASSINGLETABLE"), rs.getString("HASSOCKET"), 
						   rs.getString("CONGESTION"), rs.getString("PRICE"), rs.getString("GRADE"), 
						   rs.getString("CONTENT"), rs.getInt("LIKECOUNT"));
				   cBoards.add(cBoard);
			   } while((rs.next()) && (--countPerPage > 0));
			   
			   return cBoards;
		   }
	   } catch (Exception e){
		   e.printStackTrace();
	   } finally {
		   jdbcUtil.close();
	   }
	   return null;
   }  
   //rank
   public CommercialDTO[] rank() {

	   System.out.println("*****COMMERCIAL_DAO_RANK: ");
	   
	   String query = "SELECT * FROM (SELECT * FROM COMMERCIAL_BOARD)"
	   		+ " WHERE ROWNUM <= 3"
	   		+ " ORDER BY LIKECOUNT DESC";
	   jdbcUtil.setSqlAndParameters(query, null, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	   
	   System.out.println(query);
	   
	   CommercialDTO[] cBoards = new CommercialDTO[3];
	   try {
		   ResultSet rs = jdbcUtil.executeQuery();
		   int i = 0;
		   while (rs.next()){
			   
			   CommercialDTO cBoard = new CommercialDTO(
	                     rs.getInt("CBOARDID"), rs.getInt("USERID"), rs.getString("COMMERCIALNAME"), rs.getString("COMMERCIALCATEGORY"),
	                     rs.getString("HASWIFI"), rs.getString("HASSINGLETABLE"), rs.getString("HASSOCKET"), 
	                     rs.getString("CONGESTION"), 
	                     rs.getString("PRICE"), rs.getString("GRADE"),
	                     rs.getString("CONTENT"), rs.getInt("LIKECOUNT"));
			   cBoards[i] = cBoard; 
			   System.out.println(i + ": " + cBoards[i].getCBoardId()); 
			   i++;
		   }
		   
		   System.out.println(cBoards[0].getCBoardId());
		   System.out.println(cBoards[1].getCBoardId());
		   System.out.println(cBoards[2].getCBoardId());
		   return cBoards;
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
		   jdbcUtil.close();
	   }
	   
	   return null;
   }
}