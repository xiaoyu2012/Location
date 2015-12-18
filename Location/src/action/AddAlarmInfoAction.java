package action;


import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import po.AlarmInfo;
import po.User;
import service.AlarmInfoService;
import service.AlarmInfoServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.AlarmInfoDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class AddAlarmInfoAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(AlarmInfoDaoImpl.class);
	private static AlarmInfoService alarmInfoService = new AlarmInfoServiceImpl();
	private static UserDao userDao = new UserDaoImpl();
	private int userId;
	private int identify;
	private int syn;
	private double longitude;
	private double latitude;
	private double radius;
	private String address;
	private String type;
	private Integer state;
	private Timestamp time;
	private String remark;
	
	
	
	@Override
	public String execute() throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("在addAlarmInfoAction中的address: " + address);
		AlarmInfo alarmInfo = new AlarmInfo();
		alarmInfo.setUser(userDao.findById(userId));
		alarmInfo.setIdentify(identify);
		alarmInfo.setSyn(syn);
		alarmInfo.setLongitude(longitude);
		alarmInfo.setLatitude(latitude);
		alarmInfo.setRadius(radius);
		alarmInfo.setAddress(address);
		alarmInfo.setType(type);
		alarmInfo.setState(state);
		alarmInfo.setTime(time);
		alarmInfo.setRemark(remark);
		
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		
		
		if(alarmInfoService.addAlarmInfo(alarmInfo)) {
			pw.write("{发送成功,已接收到报警信息}");
		} else {
			pw.write("{发送失败,没有接收到报警信息}");
		}
		
		pw.flush();
		pw.close();		
		
		return SUCCESS;
	}



	

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



	public int getSyn() {
		return syn;
	}


	public void setSyn(int syn) {
		this.syn = syn;
	}





	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Integer getState() {
		return state;
	}



	public void setState(Integer state) {
		this.state = state;
	}



	public Timestamp getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = Timestamp.valueOf(time);
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	
}
