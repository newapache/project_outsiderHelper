package controller.anonymous;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.AnonymousManager;

public class AnonymousPostController implements Controller{
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		 
		 try {
	            String userid = (String)request.getParameter("curUserId");
	            System.out.println(userid);
	            request.setAttribute("curUserId", userid);
	            return "/anonymous_board/postForm.jsp";   
	              
	         } catch (Exception e) {      
	            request.setAttribute("registerFailed", true);
	            request.setAttribute("exception", e);
	            return "redirect:/anonyous_board/list";
	         }
	 }
}
