package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

import model.LectureDTO;
import model.service.LectureManager;

public class LectureUpdateController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {	
    		
				String updateId = request.getParameter("updateId");		
				
				LectureManager manager = LectureManager.getInstance();
				LectureDTO lecture = manager.findLecture(updateId);
				request.setAttribute("lecture", lecture);			
				
				return "/lecture_board/updateForm.jsp";    
			}    

    	
		LectureDTO lecture = new LectureDTO(
				request.getParameter("LectureName"),
				request.getParameter("professorName"),
				Integer.parseInt(request.getParameter("lectureYear")),
				request.getParameter("semesterDivide"),
				request.getParameter("LectureDivide"),
				request.getParameter("title"),
				request.getParameter("content"),
				request.getParameter("announcement"),
				request.getParameter("discussion"),
				request.getParameter("project"),
				request.getParameter("TotalScore"));

		LectureManager manager = LectureManager.getInstance();
		
		manager.update(lecture, Integer.parseInt(request.getParameter("lectureID")));

		return "/lecture_board/list"; 
	}

}
