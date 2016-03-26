package service;

import java.util.List;

import po.AlarmInfo;
import dao.AlarmInfoDao;
import dao.AlarmInfoDaoImpl;

public class AlarmInfoServiceImpl implements AlarmInfoService {
	private AlarmInfoDao alarmInfoDao = new AlarmInfoDaoImpl();

	@Override
	public boolean addAlarmInfo(AlarmInfo alarmInfo) {
		if(alarmInfoDao.insert(alarmInfo))
			return true;
		else
			return false;
	}

	@Override
	public AlarmInfo findById(int alarmInfoId) {
		return alarmInfoDao.findById(alarmInfoId);
	}

	@Override
	public boolean deleteAlarmInfo(int alarmInfoId) {
		if(alarmInfoDao.delete(alarmInfoId))
			return true;
		else
			return false;
	}
	

	
	@Override
	public int getAlarmInfoTotal(int state) {
		return alarmInfoDao.getAlarmInfoTotal(state);
	}

	@Override
	public List<AlarmInfo> getAlarmInfoList(int state, String page, String rows) {		
		return alarmInfoDao.getAlarmInfoList(state, page, rows);	
	}

	@Override
	public List<AlarmInfo> getOnceAlarmInfoList(int userId, int identify) {
		return alarmInfoDao.getOnceAlarmInfoList(userId, identify);
	}

	@Override
	public boolean chageState(int alarmInfoId, int state) {
		AlarmInfo ai = alarmInfoDao.findById(alarmInfoId);
		ai.setState(state);
		if(alarmInfoDao.update(ai)){
			return true;
		}else {
			return false;
		}		
	}

	

}
