package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.LectureManager;


public class LectureDeleteController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(LectureDeleteController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteId = request.getParameter("deleteId");
    	log.debug("Delete User : {}", deleteId);

    	LectureManager manager = LectureManager.getInstance();
//		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());		
    	
    		manager.delete(deleteId);			          
    		return "redirect:/lecture_board/list";	
    	
	}

}
