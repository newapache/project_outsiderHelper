package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AnonymousDTO;
import model.dao.AnonymousDAO;




public class AnonymousManager {
   private static AnonymousManager AnonymousMan = new AnonymousManager();
   private AnonymousDAO anonymousDAO;
   
   private AnonymousManager() {
      try {
         anonymousDAO = new AnonymousDAO();
         
      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   public static AnonymousManager getInstance() {
      return AnonymousMan;
   }
   public int create(AnonymousDTO anonymousDTO) throws SQLException {
      return anonymousDAO.create(anonymousDTO);
   }
   
   public int delete(String aboardID) throws SQLException {
      return anonymousDAO.delete(aboardID);
   }
   public int update(AnonymousDTO aboard, int aboardID) throws SQLException {
      return anonymousDAO.update(aboard, aboardID);
      
   }
   public ArrayList<AnonymousDTO> getList(int currentPage, int countPerPage)
         throws SQLException {
         return anonymousDAO.getList(currentPage, countPerPage);
   }
   
   public AnonymousDTO findAboard(String aboardID) throws SQLException {
      return anonymousDAO.findAboard(aboardID);
   }
   public int readCount(String aboardID) throws SQLException{
      return anonymousDAO.readCount(aboardID);
   }
   public ArrayList<AnonymousDTO> search(String category, String search, int currentPage, int countPerPage) throws SQLException{
      return anonymousDAO.search(category, search);
      //search(category, search, currentPage,  countPerPage);
   }
   
   public int countAboard() throws SQLException{
      return anonymousDAO.countAboard();
   }
   public AnonymousDAO getAnonymousDAO() {
      return this.anonymousDAO;
   }
}