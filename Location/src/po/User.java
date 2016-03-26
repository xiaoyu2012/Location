package po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sf.json.JSONObject;

@Entity
@Table(name="user")
public class User {
	/**
	 * 用户id,自增型
	 */
	@Id @Column(name="user_id")   //用户id,自增型
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	/**
	 * 用户名
	 */
	@Column(name="username", nullable=false)  	//用户名
	private String userName;	
	
	/**
	 * 用户密码
	 */
	@Column(name="password" , nullable=false)	//用户密码
	private String password;
	
	/**
	 * 性别
	 */
	@Column(name="sex")			//性别
	private String sex;
	
	/**
	 * 年龄
	 */
	@Column(name="age")			//年龄
	private Integer age;
	
	/**
	 * 电话
	 */
	@Column(name="tel", nullable=false, unique=true)			//电话
	private String tel;			
	
	/**
	 * 紧急联系人名字
	 */
	@Column(name="emergency_name")   //紧急联系人名字
	private String emergencyName;
	
	/**
	 * 紧急联系人电话
	 */
	@Column(name="emergency_tel")        	//紧急联系人电话
	private String emergencyTel;
	
	/**
	 * 注册时间
	 */
	@Column(name="create_time")		//注册时间
	private Timestamp createTime;
	
	/**
	 * 头像的URL路径
	 */
	@Column(name="image_url")		//头像的URL路径
	private String imageUrl;
	
	/**
	 * User和Location的双向1—N关系，一个用户可以发多个报警信息
	 */
	@OneToMany(targetEntity=AlarmInfo.class, mappedBy="user")  	// User和Location的双向1—N关系，一个用户可以发多个报警信息
	private Set<AlarmInfo> alarmInfos = new HashSet<>();
	
	public User() {
		
	}

	public User(Integer userId) {    // 最好要有一个含主键的构造方法，因为在Hibernate中便于查询
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyTel() {
		return emergencyTel;
	}

	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<AlarmInfo> getAlarmInfos() {
		return alarmInfos;
	}

	public void setAlarmInfos(Set<AlarmInfo> alarmInfos) {
		this.alarmInfos = alarmInfos;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sex="
				+ sex + ", age=" + age + ", emergencyName=" + emergencyName
				+ ", emergencyTel=" + emergencyTel + "]";
	}
	
	/**
	 * 返回USer对象的一个json
	 * @return 返回User对象的一个json的String
	 */
	@SuppressWarnings("deprecation")
	public String toJSONString() {      
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", this.getUserId());
		jsonObject.put("name", this.getUserName());
		jsonObject.put("tel", this.getTel());
		jsonObject.put("sex", this.getSex());
		jsonObject.put("age", this.getAge());
		jsonObject.put("ename", this.getEmergencyName());
		jsonObject.put("etel", this.getEmergencyTel());			
		return jsonObject.toString();
	}

	
}
