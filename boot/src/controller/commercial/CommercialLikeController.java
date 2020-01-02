package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CommercialManager;
import model.service.LikeManager;

public class CommercialLikeController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String cBoardId = req.getParameter("cBoardId");
		
		CommercialManager cManager = CommercialManager.getInstance();
		LikeManager lManager = LikeManager.getInstance();
		
		String userId = "1";
		
		int uResult = lManager.like(userId, cBoardId);
		int cResult = 1;
		if (cResult != 0) 
			cResult = cManager.like(cBoardId);
		
		req.setAttribute("like_uResult", uResult);
		req.setAttribute("like_cResult", cResult);
		
		return "/commercial_board/list";
	}

}
