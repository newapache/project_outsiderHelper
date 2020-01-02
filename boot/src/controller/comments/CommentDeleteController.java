package controller.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CommentManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentDeleteController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CommentDeleteController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String deleteId = request.getParameter("deleteId");
		  log.debug("Delete commentID : {}", deleteId);
       
        	 CommentManager manager = CommentManager.getInstance();
             manager.delete(deleteId);
         
            return "/anonymous_board/list";
         }

}
