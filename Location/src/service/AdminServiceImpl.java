package service;

import po.Admin;
import dao.AdminDao;
import dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	private static AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public int allowedLogin(String adminName, String password) {
		Admin admin = adminDao.findByName(adminName);	
		if(admin == null)
			return LOGIN_NOUSER;     //找不到此用户
		else if(admin.getPassword().equals(password))
			return LOGIN_SUCCESS;	//用户的电话和密码都正确
		else
			return LOGIN_FAIL;		//密码不正确	
	}

}
