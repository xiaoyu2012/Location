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
	 * 统计一共有多少报警记录， syn=1的alarmInfo算作一条报警记录
	 * @return AlarmInfoTotalNumber
	 */
	public int getAlarmInfoTotal(int state);
	
	/**
	 * 根据第几页获取，每页几行获取数据
	 * @param page 页数
	 * @param rows  每页的个数
	 * @return AlarmInfo的List
	 */
	public List<AlarmInfo> getAlarmInfoList(int state, String page, String rows);	
	
	/**
	 * 根据userId和identify查询某个用户一次报警的全部位置信息包， syn从1开始递增
	 * @param userId
	 * @param identify
	 * @return
	 */
	public List<AlarmInfo> getOnceAlarmInfoList(int userId, int identify);
	
	/**
	 * 改变state的值
	 * @param userId
	 * @param identify
	 * @param state
	 * @return
	 */
	public boolean chageState(int alarmInfoId, int state);
}
