package action;

import java.io.DataOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import service.UserService;
import service.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserLoginAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	private String tel; 			// 接受用户编号
	private String password;	// 接受用户密码	
	
	private UserService userService = new UserServiceImpl();
	private UserDao userDao = new UserDaoImpl();


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		DataOutputStream dos = new DataOutputStream(response.getOutputStream());
		int result = userService.allowedLogin(tel, password);

		if(result == UserService.LOGIN_SUCCESS ) {
			dos.writeInt(UserService.LOGIN_SUCCESS);    //1			
			dos.writeInt(userDao.findByTel(tel).getUserId());
		}  else if(result == UserService.LOGIN_NOUSER)	{
			dos.writeInt(UserService.LOGIN_NOUSER);    //2			
		} else {
			dos.writeInt(UserService.LOGIN_FAIL);   //3			
		}	
		
		dos.flush();
		dos.close();
		return null;
	
	}
}
