package dao;

import java.util.List;

import po.AlarmInfo;
import po.User;

public interface AlarmInfoDao {
	/**
	 * 插入一个AlarmInfo alarminfo
	 * @param alarminfo
	 * @return
	 */
	public boolean insert(AlarmInfo	alarminfo);   
	
	
	
	/**
	 * 更新update
	 * @param alarmInfoId
	 * @return
	 */
	public boolean update(AlarmInfo alarmInfo);
	
	/**
	 * 根据alarmInfoId查找一个AlarmInfoId对象
	 * @param alarmInfoId
	 * @return
	 */
	public AlarmInfo findById(int alarmInfoId);		//根据alarmInfoId查找一个AlarmInfoId对象

	/**
	 * 根据alarmInfoId来删除一个AlarmInfo
	 * @param alarmInfoId
	 * @return
	 */
	public boolean delete(int alarmInfoId);
	
	/**
	 * 根据第几页获取，每页几行获取数据  
	 * @param page 第几页
	 * @param rows 每页几行
	 * @return  AlarmInfoList
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
	 * 统计一共有多少数据   
	 * @return AlarmInfoTotalNumber
	 */
	public int getAlarmInfoTotal(int state);
}
