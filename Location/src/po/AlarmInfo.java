package po;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

@Entity
@Table(name="alarminfo")
public class AlarmInfo {
	/**
	 * 用户id,自增型
	 */
	@Id @Column(name="alarm_info_id")   //用户id,自增型
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer alarmInfoId;
	
	//双向N-1， 一个人可以发多个报警信息, 即多个报警信息对应一个人
	/**
	 * 双向N-1， 一个人可以发多个报警信息, 即多个报警信息对应一个人
	 */
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable=false)      //报警人的编号， 外键
	private User user; 		
	
	/**
	 * 经度
	 */
	@Column(name="longitude")  	//经度
	private double longitude;	
	
	/**
	 * 纬度
	 */
	@Column(name="latitude")  	//纬度
	private double latitude;
	
	/**
	 * 定位精度
	 */
	@Column(name="radius")		//定位精度
	private double radius;
	
	/**
	 * 文字地址信息
	 */
	@Column(name="address")    //文字地址信息
	private String address;
	
	/**
	 * 报警类型
	 */
	@Column(name="type")      	//报警类型
	private String type;
	
	/**
	 * 处理状态： 0表示未处理， 1表示处理中， 2表示已经处理完毕
	 */
	@Column(name="state")	//处理状态， 0表示未处理
	private Integer state;
	
	/**
	 * 报警时间
	 */
	@Column(name="time")		//报警时间
	private Timestamp time;
	
	/**
	 * 备注信息
	 */
	@Column(name="remark")		//备注信息
	private String remark;

	public AlarmInfo() {
		
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AlarmInfo(Integer alarmInfoId) {
		this.alarmInfoId = alarmInfoId;
	}
	
	public Integer getAlarmInfoId() {
		return alarmInfoId;
	}

	public void setAlarmInfoId(Integer alarmInfoId) {
		this.alarmInfoId = alarmInfoId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	/**
	 * 返回AlarmInfo对象的一个json
	 * @return 返回AlarmInfo对象的一个json的String
	 */
	@SuppressWarnings("deprecation")
	public String toJSONString() {      
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("alarmInfoId", this.getAlarmInfoId());
		jsonObject.put("userId", this.getUser().getUserId());
		jsonObject.put("longitude", this.getLongitude());
		jsonObject.put("latitude", this.getLatitude());
		jsonObject.put("radius", this.getRadius());
		jsonObject.put("address", this.getAddress());
		jsonObject.put("type", this.getType());
		jsonObject.put("state", this.getState());
		jsonObject.put("time", this.getTime().toGMTString());
		jsonObject.put("remark", this.getRemark());		
		return jsonObject.toString();
	}

	
	

}
