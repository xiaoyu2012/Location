package dao;

import java.util.List;

import po.User;

public interface UserDao {
	
	/**
	 * 添加一个新的用户User
	 * @param user
	 * @return
	 */
	public boolean insert(User user);   //添加一个新的用户
	
	/**
	 * 根据userId查找一个User对象
	 * @param userId
	 * @return
	 */
	public User findById(int userId);		//根据userId查找一个User对象
	
	/**
	 * 根据userName查找一个User对象。 在登陆时，用到这个方法
	 * @param userName
	 * @return
	 */
	public List<User> findByName(String userName);	//根据userName查找一个User对象。 在登陆时，用到这个方法
	
	/**
	 * 根据tel查找一个User对象。 在登陆时，用到这个方法
	 * @param tel
	 * @return
	 */
	public List<User> findByTel(String tel);
}
