package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import controller.Controller;
import model.CommercialDTO;
import model.service.CommercialManager;

public class CommercialListController implements Controller{
	private static final int countPerPage = 10;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			try {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			} catch (Exception e) {
				System.out.println("COMMERCIAL_LIST_CONTROLLER: pagenation error");
			}
		}
		
		CommercialManager manager = CommercialManager.getInstance();
		List<CommercialDTO> commercialList = manager.read(currentPage, countPerPage);
		
		request.setAttribute("commercialList", commercialList);
		
		return "/commercial_board/list.jsp";
	}
}
