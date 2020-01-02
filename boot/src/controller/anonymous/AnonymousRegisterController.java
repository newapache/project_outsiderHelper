package controller.anonymous;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.AnonymousDTO;
import model.service.AnonymousManager;

public class AnonymousRegisterController implements Controller{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
       if(request != null)
          System.out.println("널널..");
             
      
       AnonymousDTO aboard = new AnonymousDTO(
               request.getParameter("category"),
               request.getParameter("title"),
               request.getParameter("content")
               );
       
         try {
            AnonymousManager manager = AnonymousManager.getInstance();
            manager.create(aboard);
               
              return "redirect:/anonymous_board/list";   
              
         } catch (Exception e) {      
               request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            return "redirect:/anonyous_board/list";
         }
       }
    

}