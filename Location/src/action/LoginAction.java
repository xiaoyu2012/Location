package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.AdminService;
import service.AdminServiceImpl;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport {
	private String adminName; 			// 接受用户编号
	private String password;	// 接受用户密码	
	
	private AdminService adminService = new AdminServiceImpl();
	
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		int result = adminService.allowedLogin(adminName, password);
		if(result == adminService.LOGIN_SUCCESS ) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("adminName", adminName);
			return this.SUCCESS;
		} 
		else if(result == adminService.LOGIN_NOUSER)	{
			addActionError("该用户不存在!");
			return this.INPUT;
		} else {
			addActionError("密码不正确!");
			return this.INPUT;
		}
		 
	}
	
	//退出系统，清除Session和request中的内容
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "exit";
	}
}
