package controller.anonymous;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.AnonymousDTO;
import model.LectureDTO;
import model.service.AnonymousManager;
import model.service.LectureManager;

public class AnonymousUpdateController implements Controller{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
         if (request.getMethod().equals("GET")) {   
             
            String updateId = request.getParameter("updateId");      
            
            AnonymousManager manager = AnonymousManager.getInstance();
            AnonymousDTO aboard = manager.findAboard(updateId);
            request.setAttribute("aboard", aboard);         
            
            return "/anonymous_board/updateForm.jsp";    
         }    
         
       AnonymousDTO aboard = new AnonymousDTO(
               request.getParameter("category"),
               request.getParameter("title"),
               request.getParameter("content")
               );
       
       AnonymousManager manager = AnonymousManager.getInstance();
       manager.update(aboard, Integer.parseInt(request.getParameter("aboardID")));
      
       return "/anonymous_board/list";   
           
       }
    

}