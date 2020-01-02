package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.AnonymousDTO;
import model.CommentDTO;
import model.dao.AnonymousDAO;
import model.dao.CommentDAO;

public class CommentManager {
	private static CommentManager CommMan = new CommentManager();
	private CommentDAO commentDAO;
	   
	private CommentManager() {
		   try {
			   commentDAO = new CommentDAO();
		         
		   } catch (Exception e) {
		         e.printStackTrace();
		   }         
	 }
	public static CommentManager getInstance() {
	 return CommMan;
	}
	
	 public int create(CommentDTO commentDTO) throws SQLException {
	      return commentDAO.create(commentDTO);
	   }
	   
	 public int delete(String boardID) throws SQLException {
	    return commentDAO.delete(boardID);
	 }
	 public int update(CommentDTO comm, int boardID) throws SQLException {
	      return commentDAO.update(comm, boardID);
	      
	   }
	 
	 public ArrayList<CommentDTO> getList(int boardID) throws SQLException {
	         return commentDAO.getList(boardID);
	   }
	 public CommentDAO getCommentDAO() {
		      return this.commentDAO;
	 }
}
