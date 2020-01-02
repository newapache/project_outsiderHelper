package controller.anonymous;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.AnonymousDTO;
import model.service.AnonymousManager;



public class AnonymousViewController implements Controller{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
       AnonymousDTO aboard = null;
       
       AnonymousManager manager = AnonymousManager.getInstance();
       String aboardID = request.getParameter("aboardID");
      
       try {
          System.out.println("viewController");
          int rc = manager.readCount(aboardID);
          aboard = manager.findAboard(aboardID);
          aboard.setReadCount(rc);
          
       }   catch (Exception e) {            
                 return "redirect:/anonymous_board/list";
         }   
      request.setAttribute("aboard", aboard);      // 게시글 정보 저장
      return "/anonymous_board/view.jsp";            // 게시글 보기 화면으로 이동
       }
    

}