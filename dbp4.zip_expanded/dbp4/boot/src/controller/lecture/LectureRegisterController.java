package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.LectureDTO;
import model.service.LectureManager;

public class LectureRegisterController implements Controller{
	
	 @Override
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 if(request != null)
			 System.out.println("널널..");

								
		 	LectureDTO lecture = new LectureDTO(request.getParameter("LectureName"),
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
	

			try {
				LectureManager manager = LectureManager.getInstance();
				manager.create(lecture);
		        return "redirect:/lecture_board/list";	
		        
			} catch (Exception e) {		
	            request.setAttribute("registerFailed", true);
				request.setAttribute("exception", e);
				return "redirect:/lecture_board/list";
			}
	    }

}
