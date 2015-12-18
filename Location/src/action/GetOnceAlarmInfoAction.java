package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import po.AlarmInfo;
import po.User;
import service.AlarmInfoService;
import service.AlarmInfoServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.AlarmInfoDaoImpl;

/**
 * 返回一次报警时的全部的位置信息， identify相同， syn从1开始递增。
 */
public class GetOnceAlarmInfoAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(AlarmInfoDaoImpl.class);
	private static AlarmInfoService alarmInfoService = new AlarmInfoServiceImpl();
	private int userId;
	private int identify;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIdentify() {
		return identify;
	}
	public void setIdentify(int identify) {
		this.identify = identify;
	}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("userId = " + userId + ", identify = " + identify);
		HttpServletRequest request = ServletActionContext.getRequest();
		List<AlarmInfo> alarmInfos = alarmInfoService.getOnceAlarmInfoList(userId,identify);
		request.setAttribute("alarmInfos", alarmInfos);		
		return SUCCESS;
	}
	
	
	

}
