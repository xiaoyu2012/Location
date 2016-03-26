package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import po.User;
import service.UserService;
import service.UserServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserInfo extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		User user = userService.findById(userId);
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		pw.write(user.toJSONString());	
		System.out.println(user.toJSONString());
		pw.flush();
		pw.close();	
		return SUCCESS;

	}
}
