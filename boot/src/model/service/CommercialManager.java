package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.CommercialDTO;
import model.dao.CommercialDAO;;

public class CommercialManager {

   private static CommercialManager cManager = new CommercialManager();
   private CommercialDAO cDAO;
   
   private CommercialManager() {
      
      try {
         cDAO = new CommercialDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static CommercialManager getInstance() {
      return cManager;
   }
   
   //create
   public int create(CommercialDTO cDTO) throws SQLException {
      System.out.println("*****COMMERCIAL_MANAGER: " + cDTO.getCommercialName() + "::" + cDTO.getCongestion() + "::" + cDTO.getPrice() +"::" + cDTO.getGrade());
      return cDAO.create(cDTO);
   }
   //read
   public ArrayList<CommercialDTO> read(int currentPage, int countPerPage) throws SQLException {
      try {
         System.out.println("*****COMMERCIAL_MANAGER: ");
         return cDAO.read(currentPage, countPerPage);
      } catch (Exception e){
         System.out.println("*****COMMERCIAL_MANAGER: CALL DAO.READ FAIL");
         return null;
      }
      
   }
   //search
   public CommercialDTO search(String commercialId) throws SQLException {
      
      return cDAO.search(commercialId);
   }
   //delete
   public int delete(String commercialId) throws SQLException {
      return cDAO.delete(commercialId);
   }
   //update
   public int update(CommercialDTO cBoard, int cBoardId) throws SQLException {
	   return cDAO.update(cBoard, cBoardId);
   }
   //like
   public int like(String cBoardId) throws SQLException {
	   return cDAO.like(cBoardId);
   }
   //filter
   public ArrayList<CommercialDTO> filter(String commercialName, String commercialCategory, 
		   String hasWifi, String hasSingleTable, String hasSocket,
		   String congestion, String price,
		   int currentPage, int countPerPage) {
	   return cDAO.filter(commercialName, commercialCategory, hasWifi, hasSingleTable, hasSocket, congestion, price, currentPage, countPerPage);
   }
   //rank
   public CommercialDTO[] rank() {
	   return cDAO.rank();
   }
}