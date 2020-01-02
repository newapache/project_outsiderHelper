package controller.anonymous;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.AnonymousManager;


public class AnonymousDeleteController implements Controller{

    private static final Logger log = LoggerFactory.getLogger(AnonymousDeleteController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {
      String deleteId = request.getParameter("deleteId");
       log.debug("Delete aboardID : {}", deleteId);

       AnonymousManager manager = AnonymousManager.getInstance();
//      String curUserId = UserSessionUtils.getUserFromSession(request.getSession());      
       
          manager.delete(deleteId);                   
          return "redirect:/anonymous_board/list";   
       
   }

}