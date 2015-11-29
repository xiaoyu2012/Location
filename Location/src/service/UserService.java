package service;

import java.util.List;

import po.User;

public interface UserService {
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_NOUSER = 2;
	public static final int LOGIN_FAIL = 3;
	/**
	 * 添加一个新用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	
	/**
	 * 根据手机号和密码，判断是否能够登陆
	 * @param UserName 用户名
	 * @param password 密码
	 * @return
	 */
	public int allowedLogin(int	userId, String password);
	
	public List<User> showAllUser();

}
