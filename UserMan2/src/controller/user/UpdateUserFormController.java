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
		User user = manager.findUser(userId);	// ����� ���� �˻�
		request.setAttribute("user", user);						
		
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		if (curUserId != null && 
			(curUserId.equals(userId) || curUserId.equals("admin"))) {
			// ���� �α����� ����ڰ� �������̰ų� ���� ��� ������� ��� -> ���� ����
			return "/user/updateForm.jsp";   // �˻��� ����� ������ update form���� ����     
		}
		// else ����� ���� ȭ������ ���� �޼����� ����
		request.setAttribute("updateFailed", true);
		request.setAttribute("exception", 
			new IllegalStateException("�ٸ� ������� ������ ������ �� �����ϴ�."));            
		return "/user/view.jsp";		// ����� ���� ȭ������ �̵� (forwarding)
    }
}
