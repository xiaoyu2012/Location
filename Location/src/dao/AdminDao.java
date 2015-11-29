package dao;

import po.Admin;

public interface AdminDao {
	
	
	/**
	 * 根据id查找Admin
	 * @param adminId
	 * @return
	 */
	
	
	public Admin findById(int adminId);    
	
	/**
	 * 根据adminName查找Admin
	 * @param adminName
	 * @return
	 */
	public Admin findByName(String adminName);

}
