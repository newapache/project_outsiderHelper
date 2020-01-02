package controller;

import java.util.HashMap;
import java.util.Map;
import controller.lecture.*;
import controller.user.DeleteUserController;
import controller.user.ListUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.RegisterUserController;
import controller.user.UpdateUserController;
import controller.user.UpdateUserFormController;
import controller.user.ViewUserController;
import controller.anonymous.*;

public class RequestMapping {

    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));
        //로그인  
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/update/form", new UpdateUserFormController());
        mappings.put("/user/delete", new DeleteUserController());
 
        //강의  
        mappings.put("/lecture_board/list", new LectureListController()); 
        mappings.put("/lecture_board/register", new LectureRegisterController()); 
        mappings.put("/lecture_board/delete", new LectureDeleteController() ) ;
        mappings.put("/lecture_board/update/form", new LectureUpdateController() ) ;
        mappings.put("/lecture_board/update", new LectureUpdateController() ) ;
        mappings.put("/lecture_board/like", new LectureLikeController() ) ;
        mappings.put("/lecture_board/search", new LectureSearchController() ) ; 
        //익명  
        mappings.put("/anonymous_board/list",  new AnonymousListController());
        mappings.put("/anonymous_board/register", new AnonymousRegisterController());
        mappings.put("/anonymous_board/register/post",  new ForwardController("/anonymous_board/postForm.jsp"));
        mappings.put("/anonymous_board/view",  new AnonymousViewController());
        mappings.put("/anonymous_board/delete", new AnonymousDeleteController() ) ;
        mappings.put("/anonymous_board/update", new AnonymousUpdateController());
        mappings.put("/anonymous_board/update/form", new AnonymousUpdateController());
        mappings.put("/anonymous_board/search", new AnonymousSearchController()) ; 

   
       // logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 
        return mappings.get(uri);
    }
}
