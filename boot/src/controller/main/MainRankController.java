package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CommercialDTO;
import model.service.CommercialManager;
import model.LectureDTO;
import model.service.LectureManager;

public class MainRankController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("*****MAIN_RANK_CONTROLLER: ");
		
		LectureManager lManager = LectureManager.getInstance();
		LectureDTO[] lBoards = lManager.rank();
		CommercialManager cManager = CommercialManager.getInstance();
		CommercialDTO[] cBoards = cManager.rank();
		
		System.out.println(cBoards[1].getCBoardId() + "::" + cBoards[1].getCBoardId() + "::" + cBoards[2].getCBoardId());
		
		req.setAttribute("lBoards", lBoards);
		req.setAttribute("cBoards", cBoards);
	
		return "/index.jsp";
	}
	
}
