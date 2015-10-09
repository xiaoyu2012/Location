package action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import po.AlarmInfo;
import po.User;
import service.AlarmInfoService;
import service.AlarmInfoServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class Test {
	public static void main(String[] args) {
		User user1 = new User();
		user1.setUserName("杨宇航");
		user1.setPassword("1234");
		user1.setTel("15623236300");
		UserService userService = new UserServiceImpl();
		userService.addUser(user1);
		AlarmInfo ai = new AlarmInfo();
		ai.setUser(user1);
		ai.setLatitude(30.2);
		ai.setLongitude(114.35);
		ai.setRadius(20.23);
		ai.setState(0);
		AlarmInfoService alarmService = new AlarmInfoServiceImpl();
		alarmService.addAlarmInfo(ai);
		List list = alarmService.getAlarmInfoList("1", "5");
		List<String> jsonList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			AlarmInfo alarmInfo = (AlarmInfo)list.get(i);
			jsonList.add(toJSONString(alarmInfo));
			System.out.println(toJSONString(alarmInfo));
		}
		
		try {
			toBeJson(jsonList, alarmService.getAlarmInfoTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String toJSONString(AlarmInfo alarmInfoJson) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("alarmInfoId", alarmInfoJson.getAlarmInfoId());
		jsonObject.put("userId", alarmInfoJson.getUser().getUserId());
		jsonObject.put("longitude", alarmInfoJson.getLongitude());
		jsonObject.put("latitude", alarmInfoJson.getLatitude());
		jsonObject.put("radius", alarmInfoJson.getRadius());
		jsonObject.put("address", alarmInfoJson.getAddress());
		jsonObject.put("type", alarmInfoJson.getType());
		jsonObject.put("state", alarmInfoJson.getState());
		jsonObject.put("time", alarmInfoJson.getTime());
		jsonObject.put("remark", alarmInfoJson.getRemark());		
		return jsonObject.toString();
	}
	public static void toBeJson(List jsonList, int total) throws Exception {
		//HttpServletResponse response = ServletActionContext.getResponse();
		//HttpServletRequest request = ServletActionContext.getRequest();

		JSONObject jsonObject = new JSONObject();// new一个JSON
		jsonObject.accumulate("total", total);// total代表一共有多少数据
		jsonObject.accumulate("rows", jsonList);// row是代表显示的页的数据
		System.out.println(jsonObject.toString());
	//	response.setCharacterEncoding("utf-8");// 指定为utf-8
	//	response.getWriter().write(jobj.toString());// 转化为Json格式

	}

}
