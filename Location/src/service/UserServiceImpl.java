package service;

import java.util.List;

import po.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private static UserDao userDao = new UserDaoImpl();

	@Override
	public boolean addUser(User user) {
		if(userDao.insert(user))
			return true;
		else
			return false;
	}

	@Override
	public int allowedLogin(String tel, String password) {
		User user = userDao.findByTel(tel);
		if(user == null)
			return LOGIN_NOUSER;     //找不到此用户
		else if(user.getPassword().equals(password))
			return LOGIN_SUCCESS;	//用户的电话和密码都正确
		else
			return LOGIN_FAIL;		//密码不正确	
		
	}

	@Override
	public List<User> showAllUser() {
		List<User> users = userDao.findAll();
			return users;
	}

	@Override
	public User findById(int id) {
		
		return userDao.findById(id);
	}
	


}
