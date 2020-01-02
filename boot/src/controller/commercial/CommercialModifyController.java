package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CommercialDTO;
import model.service.CommercialManager;

public class CommercialModifyController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if (req.getMethod().equals("GET")) {
			
			System.out.println("****COMMERCIAL_MODIFY_COMTROLLER:MODIFY_FORM");
			
			String cBoardId = req.getParameter("cBoardId");
			CommercialManager manager = CommercialManager.getInstance();
			CommercialDTO cBoard = manager.search(cBoardId);
			
			System.out.println("*****COMMECIAL_MODIFY_CONTROLLER:SEARCH");
			System.out.println("cBoardId: " + cBoard.getCBoardId());
			
			req.setAttribute("cBoard", cBoard);
			
			return "/commercial_board/modifyForm.jsp";
		}
		
		System.out.println("****COMMERCIAL_MODIFY_COMTROLLER:MODIFY");
		
		CommercialDTO cBoard = new CommercialDTO(
				req.getParameter("commercialName"), req.getParameter("commercialCategory"),
				req.getParameter("hasWifi"), req.getParameter("hasSingleTable"), req.getParameter("hasSocket"),
				req.getParameter("congestion"), req.getParameter("price"), req.getParameter("grade"),
				req.getParameter("content"));
		
		CommercialManager manager = CommercialManager.getInstance();
		manager.update(cBoard, Integer.parseInt(req.getParameter("cBoardId")));
		
		return "/commercial_board/list";
	}

	
}
