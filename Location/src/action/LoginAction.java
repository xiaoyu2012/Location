package action;

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
}
