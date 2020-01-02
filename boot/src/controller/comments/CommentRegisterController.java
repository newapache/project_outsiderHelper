package controller.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.CommentDTO;
import model.service.CommentManager;

public class CommentRegisterController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	     
			CommentDTO comm = new CommentDTO(
	               request.getParameter("content"),
	               request.getParameter("curUserId"),
	               Integer.parseInt(request.getParameter("boardID"))
	               );
			
			System.out.println(comm.getContent());
			System.out.println(comm.getBoardID());
			System.out.println(comm.getUserID());
	       
	         try {
	        	 CommentManager manager = CommentManager.getInstance();
	             manager.create(comm);
	              request.setAttribute("aboardID", comm.getBoardID());
	              return "/anonymous_board/list";   
	              
	         } catch (Exception e) {      
	            request.setAttribute("registerFailed", true);
	            request.setAttribute("exception", e);
	            return "redirect:/anonyous_board/list";
	         }
	       }
	    
}
