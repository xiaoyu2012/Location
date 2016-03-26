package test;

import static org.junit.Assert.fail;

import org.junit.Test;

import po.User;
import service.UserService;
import service.UserServiceImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserDaoTest {
	UserService us = new UserServiceImpl();
	@Test
	public void save() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUserId(8);
		user.setTel("15623236311");
		user.setPassword("987");
		user.setUserName("yyh");
		userDao.insert(user);
	}
	
	
	@Test
	public void find(){
		User user = us.findById(6);
		System.out.println(user.toJSONString());
	}

}
