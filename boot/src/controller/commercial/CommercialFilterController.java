package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import controller.Controller;
import model.service.CommercialManager;
import model.CommercialDTO;

public class CommercialFilterController implements Controller {
	
	private static final int countPerPage = 10;

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String currentPageStr = req.getParameter("currentPage");
		int currentPage = 1;
		
		if (req.getParameter("currentPage") != null) {
			try {
				currentPage = Integer.parseInt(req.getParameter("currentPage"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		System.out.println("*****COMMERCIAL_FILTER_CONTROLLER: ");
		
		String commercialName = req.getParameter("commercialName");
		String commercialCategory = req.getParameter("commercialCategory");
		String hasWifi = req.getParameter("hasWifi");
		String hasSingleTable = req.getParameter("hasSingleTable");
		String hasSocket = req.getParameter("hasSocket");
		String congestion = req.getParameter("congestion");
		String price = req.getParameter("price");
		
		System.out.println(req.getParameter("commercialName") + "::" + req.getParameter("commercialCategory"));
		System.out.println(req.getParameter("hasWifi") + "::" + req.getParameter("hasSingleTable") + "::" + req.getParameter("hasSocket"));
		System.out.println(req.getParameter("congestion") + "::" + req.getParameter("price"));
		
		CommercialManager manager = CommercialManager.getInstance();
		ArrayList<CommercialDTO> cBoards = manager.filter(commercialName, commercialCategory, 
				hasWifi, hasSingleTable, hasSocket, congestion, price, currentPage, countPerPage);
		req.setAttribute("commercialList", cBoards);
		
		return "/commercial_board/list.jsp";
	}

}
