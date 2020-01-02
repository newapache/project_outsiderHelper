package controller.lecture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.LectureManager;
import model.service.LikeManager;

public class LectureLikeController implements Controller{
    private static final Logger log = LoggerFactory.getLogger(LectureDeleteController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
    //	String userId = request.getParameter("userId");
		String likeId = request.getParameter("likeId");
    	log.debug("like : {}", likeId);

    	LectureManager lecturemanager = LectureManager.getInstance();	
    	LikeManager likeManager = LikeManager.getInstance();
    	
    	
    	String userId ="0";
    	
    	int result = likeManager.like(userId, likeId); // 0이면 중복 
    	int result2 = 1;
    	if(result != 0)
    		result2 = lecturemanager.like(likeId); 
    		
    	request.setAttribute("likeresult", result);	
    	request.setAttribute("likeresult2", result2);	
    	return "/lecture_board/list";	
    	
	}

}
