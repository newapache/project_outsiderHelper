package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LectureDTO;
import model.dao.LectureDAO;


public class LectureManager {
	private static LectureManager lectureMan = new LectureManager();
	private LectureDAO lectureDAO;

	private LectureManager() {
		try {
			lectureDAO = new LectureDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	public static LectureManager getInstance() {
		return lectureMan;
	}
	public int create(LectureDTO lectureDTO) throws SQLException {
		return lectureDAO.create(lectureDTO);
	}
	public ArrayList<LectureDTO> getList(int currentPage, int countPerPage)
			throws SQLException {
			return lectureDAO.getList(currentPage, countPerPage);
		}
	
	public int delete(String LectureID) throws SQLException {
		return lectureDAO.delete(LectureID);
	}
	public int like(String LectureID) throws SQLException {
		return lectureDAO.like(LectureID);
	}
	public LectureDTO findLecture(String LectureID) throws SQLException {
		return lectureDAO.findLecture(LectureID);
	}
	
	public LectureDAO getLectureDAO() throws SQLException {
		return this.lectureDAO;
	}
	public int update(LectureDTO lecture, int lectureID) throws SQLException {
		return lectureDAO.update(lecture, lectureID);
		
	}
	public  ArrayList<LectureDTO> search(String lectureName, String professorName, String LectureDivide,String announcement, String discussion,
			String project,int currentPage, int countPerPage) {
		return lectureDAO.search(lectureName, professorName, LectureDivide,announcement, discussion, project,currentPage, countPerPage);
		
	}


}
