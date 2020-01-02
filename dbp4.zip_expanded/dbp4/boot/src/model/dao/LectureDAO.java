package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LectureDTO;

public class LectureDAO {
	
private JDBCUtil jdbcUtil = null;
	
	public LectureDAO() {			
		jdbcUtil = new JDBCUtil();	
	}
	public int create(LectureDTO lectureDTO) {
		
		
		String sql = "INSERT INTO LECTURE_BOARD VALUES (BOARDNUM.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] { 1,lectureDTO.getLectureName(), lectureDTO.getProfessorName(),
				lectureDTO.getLectureYear(),lectureDTO.getSemesterDivide(),lectureDTO.getLectureDivide(),lectureDTO.getTitle(),
				lectureDTO.getContent(), lectureDTO.getHasAnnounceMent(), lectureDTO.getHasDebate(), lectureDTO.getHasProject(),
				lectureDTO.getTotalScore(), 0};				
		jdbcUtil.setSqlAndParameters(sql, param);	

		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;	
	}
	
	
	public ArrayList<LectureDTO> getList(int currentPage, int countPerPage) {

	    String sql = "SELECT * FROM LECTURE_BOARD ORDER BY LBOARDID DESC";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				ArrayList<LectureDTO> LectureList = new ArrayList<LectureDTO>();	// User���� ����Ʈ ����
				do {
					LectureDTO lecture = new LectureDTO(
						rs.getInt("LBOARDID"),
						rs.getInt("USERID"),
						rs.getString("LECTURENAME"),
						rs.getString("PROFESSORNAME"),
						rs.getInt("LECTUREYEAR"),
						rs.getString("SEMESTERDIVIDE"),
						rs.getString("LECTUREDIVIDE"),
						rs.getString("TITLE"),
						rs.getString("CONTENT"),
						rs.getString("HASANNOUNCEMENT"),
						rs.getString("HASDEBATE"),
						rs.getString("HASPROJECT"),
						rs.getString("TOTALSCORE"),
						rs.getInt("LIKECOUNT"));
					
					System.out.println("hello");
					LectureList.add(lecture);							// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return LectureList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;

	}
	public int delete(String lectureID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM LECTURE_BOARD WHERE LBOARDID=?";		
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {lectureID});
		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}
	
	public int like(String lectureID) {

		String sql = "UPDATE LECTURE_BOARD SET likeCount = likeCount + 1 WHERE LBOARDID = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {lectureID});
		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
		

	}
	public LectureDTO findLecture(String lectureID) {
		
		String sql = "SELECT * FROM LECTURE_BOARD WHERE LBOARDID=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {lectureID});

		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			if (rs.next()) {					
				LectureDTO lecture = new LectureDTO(
						rs.getInt("LBOARDID"),
						rs.getInt("USERID"),
					rs.getString("LECTURENAME"),
					rs.getString("PROFESSORNAME"),
					rs.getInt("LECTUREYEAR"),
					rs.getString("SEMESTERDIVIDE"),
					rs.getString("LECTUREDIVIDE"),	
					rs.getString("TITLE"),					
					rs.getString("CONTENT"),
					rs.getString("HASANNOUNCEMENT"),
					rs.getString("HASDEBATE"),
					rs.getString("HASPROJECT"),
					rs.getString("TOTALSCORE"),
					rs.getInt("LIKECOUNT")
						);
				return lecture;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public int update(LectureDTO lecture, int lectureId){
		String sql = "UPDATE LECTURE_BOARD "
					+ "SET LECTURENAME=?, PROFESSORNAME=?, LECTUREYEAR=?, SEMESTERDIVIDE=?, LECTUREDIVIDE=?, TITLE=?, CONTENT=?, HASANNOUNCEMENT=?, HASDEBATE=?, HASPROJECT=?,TOTALSCORE=? "
					+ "WHERE LBOARDID=?";
		Object[] param = new Object[] {lecture.getLectureName(), lecture.getProfessorName(), lecture.getLectureYear(), lecture.getSemesterDivide(), lecture.getLectureDivide(),
				lecture.getTitle(), lecture.getContent(), lecture.getHasAnnounceMent(), lecture.getHasDebate(), lecture.getHasProject(), lecture.getTotalScore(),
					lectureId};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}
	public ArrayList<LectureDTO> search(String lectureName, String professorName, String LectureDivide, String announcement,
			String discussion, String project,int currentPage, int countPerPage) {
		
		String sql = null;
		Object[] param = null;
		
		if(lectureName == null && professorName != null) {
			sql = "SELECT * FROM LECTURE_BOARD WHERE PROFESSORNAME LIKE '%'||? ||'%' AND LECTUREDIVIDE=? AND HASANNOUNCEMENT=? AND HASDEBATE=? AND HASPROJECT=? ORDER BY LBOARDID DESC";	
			param = new Object[] {professorName, LectureDivide, announcement, discussion, project};				

		}
		else if(professorName == null && lectureName != null) {
			sql = "SELECT * FROM LECTURE_BOARD WHERE LECTURENAME LIKE '%'||? ||'%' AND LECTUREDIVIDE=? AND HASANNOUNCEMENT=? AND HASDEBATE=? AND HASPROJECT=? ORDER BY LBOARDID DESC";
			param = new Object[] {lectureName, LectureDivide,announcement, discussion, project};				
		}
		else if(professorName == null && lectureName == null) {
			sql = "SELECT * FROM LECTURE_BOARD WHERE LECTUREDIVIDE=? AND HASANNOUNCEMENT=? AND HASDEBATE=? AND HASPROJECT=? ORDER BY LBOARDID DESC";
			param = new Object[] {LectureDivide, announcement, discussion, project};			
		}
		else {
			sql = "SELECT * FROM LECTURE_BOARD WHERE LECTURENAME LIKE '%'||? ||'%' AND PROFESSORNAME LIKE '%'||? ||'%' AND LECTUREDIVIDE=? AND HASANNOUNCEMENT=? AND HASDEBATE=? AND HASPROJECT=? ORDER BY LBOARDID DESC";			
		param = new Object[] {lectureName, professorName, LectureDivide, announcement, discussion, project};				
		}

		jdbcUtil.setSqlAndParameters(sql, param,  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
			try {
				ResultSet rs = jdbcUtil.executeQuery();				// query ����			
				int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
				
				if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
					ArrayList<LectureDTO> LectureList = new ArrayList<LectureDTO>();	// User���� ����Ʈ ����
					do {
						LectureDTO lecture = new LectureDTO(
							rs.getInt("LBOARDID"),
							rs.getInt("USERID"),
							rs.getString("LECTURENAME"),
							rs.getString("PROFESSORNAME"),
							rs.getInt("LECTUREYEAR"),
							rs.getString("SEMESTERDIVIDE"),
							rs.getString("LECTUREDIVIDE"),
							rs.getString("TITLE"),
							rs.getString("CONTENT"),
							rs.getString("HASANNOUNCEMENT"),
							rs.getString("HASDEBATE"),
							rs.getString("HASPROJECT"),
							rs.getString("TOTALSCORE"),
							rs.getInt("LIKECOUNT"));
						
						LectureList.add(lecture);							// ����Ʈ�� User ��ü ����
					} while ((rs.next()) && (--countPerPage > 0));		
					return LectureList;							
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
			return null;
	}



}


