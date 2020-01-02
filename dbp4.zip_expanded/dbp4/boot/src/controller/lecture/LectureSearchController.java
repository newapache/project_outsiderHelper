package controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.LectureDTO;
import model.service.LectureManager;

public class LectureSearchController implements Controller{
	private static final int countPerPage = 10;
	   
	@Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		
		
		String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		
		
		if(request.getParameter("currentPage") != null) {
			try {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			} catch (Exception e) {
				System.out.println("검색 페이지 번호 오류");
			}
		}
		
		
		
			String LectureName = null;
			if(request.getParameter("LectureName")!= null)
				LectureName = request.getParameter("LectureName");
			
			String professorName = null;
			if(request.getParameter("professorName")!= null)
				professorName = request.getParameter("professorName");
			
			String LectureDivide = null;
			if(request.getParameter("LectureDivide")!= null)
				LectureDivide = request.getParameter("LectureDivide");
			
			String announcement = null;
			if(request.getParameter("announcement")!= null)
				announcement = request.getParameter("announcement");
			
			String discussion = null;
			if(request.getParameter("discussion")!= null)
				discussion = request.getParameter("discussion");
			
			String project = null;
			if(request.getParameter("project")!= null)
				project = request.getParameter("project");
		

			LectureManager manager = LectureManager.getInstance();	
	    	
			
			List<LectureDTO> lectureList =  manager.search(LectureName, professorName,LectureDivide,announcement,discussion,project, currentPage, countPerPage);			          
	    	request.setAttribute("lectureList", lectureList);	
	    	return "/lecture_board/list.jsp";	
	    	
		}

}
