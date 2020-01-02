package controller.anonymous;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.AnonymousDTO;
import model.service.AnonymousManager;

public class AnonymousListController implements Controller {
    private static final int countPerPage = 20;   // 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {
      // 로그인 여부 확인
       //if (!UserSessionUtils.isLogined(request.getSession())) {
        //    return "redirect:/user/login/form";      // login form 요청으로 redirect
        //}
       
       
       String currentPageStr = request.getParameter("currentPage");   
      int currentPage = 1;
      
      
      if(request.getParameter("currentPage") != null) {
         try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
         } catch (Exception e) {
            System.out.println("에러");
         }
      }      
       
       
       AnonymousManager manager = AnonymousManager.getInstance();
      List<AnonymousDTO> AboardList = manager.getList(currentPage, countPerPage);
      
      int count = manager.countAboard();
      
      // userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
      request.setAttribute("AboardList", AboardList);
      request.setAttribute("count", count);
      request.setAttribute("currentPage", currentPage);
      //request.setAttribute("curUserId", 
      //      UserSessionUtils.getUserFromSession(request.getSession()));      

      // 사용자 리스트 화면으로 이동(forwarding)
      return "/anonymous_board/list.jsp";        
    }
}