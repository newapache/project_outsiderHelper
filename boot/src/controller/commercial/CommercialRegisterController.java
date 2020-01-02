package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CommercialDTO;
import model.service.CommercialManager;

public class CommercialRegisterController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		CommercialDTO commercial = new CommercialDTO(req.getParameter("commercialName"), req.getParameter("commercialCategory"),
				req.getParameter("hasWifi"), req.getParameter("hasSingleTable"), req.getParameter("hasSocket"),
				req.getParameter("congestion"), req.getParameter("price"), req.getParameter("grade"),
				req.getParameter("content"));
		
		System.out.println(req.getParameter("congestion"));
		System.out.println(req.getParameter("price"));
		System.out.println(req.getParameter("grade"));
		
		try {
			System.out.println("*****1COMMERCIAL_REGISTER_CONTROLLER: " + commercial.getCommercialName() + "::" + req.getParameter("grade"));
			
			CommercialManager manager = CommercialManager.getInstance();
			manager.create(commercial);
			
			System.out.println("*****2COMMERCIAL_REGISTER_CONTROLLER: " + commercial.getCommercialName());
			
			return "redirect:/commercial_board/list";
		} catch(Exception e) {
			req.setAttribute("fail_registerCommercialB", true);
			req.setAttribute("excetion", e);
			return  "redirect:/commercial_board/list";
		}
	}
}
