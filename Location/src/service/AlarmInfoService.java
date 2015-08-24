package service;

import java.util.List;

import po.AlarmInfo;

public interface AlarmInfoService {
	
	/**
	 * 添加一条报警信息
	 * @param alarmInfo
	 * @return
	 */
	public boolean addAlarmInfo(AlarmInfo alarmInfo);
	
	/**
	 * 根据ID查找一条报警信息
	 * @param alarmInfoId
	 * @return
	 */
	public AlarmInfo findById(int alarmInfoId);
	
	/**
	 * 根据ID删除一条报警信息
	 * @param alarmInfoId
	 * @return
	 */
	public boolean deleteAlarmInfo(int alarmInfoId);
	
	
	/**
	 * 统计一共有多少数据   
	 * @return AlarmInfoTotalNumber
	 */
	public int getAlarmInfoTotal();
	
	/**
	 * 根据第几页获取，每页几行获取数据
	 * @param page 页数
	 * @param rows  每页的个数
	 * @return AlarmInfo的List
	 */
	public List<AlarmInfo> getAlarmInfoList(String page, String rows);	

}
