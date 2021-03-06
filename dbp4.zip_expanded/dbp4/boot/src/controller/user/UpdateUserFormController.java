package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.User;

public class UpdateUserFormController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		
		UserManager manager = UserManager.getInstance();
		User user = manager.findUser(userId);	// 사용자 정보 검색
		request.setAttribute("user", user);						
		
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		if (curUserId != null && 
			(curUserId.equals(userId) || curUserId.equals("admin"))) {
			// 현재 로그인한 사용자가 관리자이거나 수정 대상 사용자인 경우 -> 수정 가능
			return "/user/updateForm.jsp";   // 검색한 사용자 정보를 update form으로 전송     
		}
		// else 사용자 보기 화면으로 오류 메세지를 전달
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", 
			new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다."));            
		return "/user/view.jsp";		// 사용자 보기 화면으로 이동 (forwarding)
    }
}
