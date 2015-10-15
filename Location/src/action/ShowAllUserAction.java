package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import po.User;
import service.UserService;
import service.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class ShowAllUserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> users = userService.showAllUser();
		request.setAttribute("users", users);
		return this.SUCCESS;

	}
	
}
