package controller.commercial;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.CommercialManager;

public class CommercialDeleteController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CommercialDeleteController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deleteId = request.getParameter("deleteId");
		log.debug("*****DELETE COMMERCIAL BOARD: {}", deleteId);
		
		CommercialManager manager = CommercialManager.getInstance();
		manager.delete(deleteId);
		return "redirect:/commercial_board/list";
	}
	
}
