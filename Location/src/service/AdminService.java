package service;

public interface AdminService {
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_NOUSER = 2;
	public static final int LOGIN_FAIL = 3;
	
	/**
	 * 根据管理员名和密码，判断是否能够登陆
	 * @param adminName
	 * @param password
	 * @return 登陆状态
	 */
	public int allowedLogin(String adminName, String password);
}
