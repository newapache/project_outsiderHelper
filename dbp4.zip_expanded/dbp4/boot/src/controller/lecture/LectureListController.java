package controller.lecture;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.LectureDTO;
import model.service.LectureManager;


public class LectureListController implements Controller {
	private static final int countPerPage = 10;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		// �α��� ���� Ȯ��
//    	if (!UserSessionUtils.isLogined(request.getSession())) {
//            return "redirect:/user/login/form";		// login form ��û���� redirect
//        }
//    	
    	
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		
		
		if(request.getParameter("currentPage") != null) {
			try {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			} catch (Exception e) {
				System.out.println("검색 페이지 번호 오류");
			}
		}
		LectureManager manager = LectureManager.getInstance();
		List<LectureDTO> lectureList = manager.getList(currentPage, countPerPage);
		
		// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("lectureList", lectureList);				
//		request.setAttribute("curUserId", 
//				UserSessionUtils.getUserFromSession(request.getSession()));		

		// ����� ����Ʈ ȭ������ �̵�(forwarding)
		return "/lecture_board/list.jsp";        
    }
}
