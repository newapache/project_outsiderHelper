package controller.anonymous;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.AnonymousDTO;
import model.service.AnonymousManager;

public class AnonymousSearchController implements Controller{
   private static final int countPerPage = 15;
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
       String currentPageStr = request.getParameter("currentPage");   
         int currentPage = 1;
             
       String[] category = request.getParameterValues("AnonymousDivide");
       String search = request.getParameter("search");
       String cg = category[0];
       
      
       AnonymousManager manager = AnonymousManager.getInstance();
       
       List<AnonymousDTO> AboardList = manager.search(cg, search, currentPage, countPerPage);
       request.setAttribute("AboardList", AboardList);
       
       return "/anonymous_board/list.jsp";
       }
   
}