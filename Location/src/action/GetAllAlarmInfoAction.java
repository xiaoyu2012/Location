package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import po.AlarmInfo;
import service.AlarmInfoService;
import service.AlarmInfoServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import dao.AlarmInfoDaoImpl;


public class GetAllAlarmInfoAction extends ActionSupport {
	private static final Log log = LogFactory.getLog(AlarmInfoDaoImpl.class);
	private JSONObject jsonObj;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private AlarmInfoService alarmInfoService;

	
	// 查询出所有报警信息
	public String getAllAlarmInfo() throws Exception {  
		alarmInfoService = new AlarmInfoServiceImpl();
		System.out.println("page=" + page + ", rows=" + rows);
		List list = alarmInfoService.getAlarmInfoList(page, rows);
		List<String> jsonList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++){
			AlarmInfo alarmInfo = (AlarmInfo)list.get(i);
			jsonList.add(alarmInfo.toJSONString()); 
			//jsonList.add(((AlarmInfo)list.get(i)).toJSONString());    //合并上面两句话
			System.out.println(alarmInfo.toJSONString());
		}
			
		
		this.toBeJson(jsonList, jsonList.size());
		return SUCCESS;
	}

	// 转化为Json格式
	public void toBeJson(List jsonList, int total) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		//HttpServletRequest request = ServletActionContext.getRequest();

		JSONObject jsonObject = new JSONObject();// new一个JSON
		jsonObject.accumulate("total", total);// total代表一共有多少数据
		jsonObject.accumulate("rows", jsonList);// row是代表显示的页的数据
		System.out.println(jsonObject.toString());
		response.setCharacterEncoding("utf-8");// 指定为utf-8
		response.setContentType("text/json");
		PrintWriter pw = response.getWriter();
		pw.write(jsonObject.toString());// 转化为Json格式
		pw.flush();
		pw.close();
		 
		log.info(jsonObject.toString());
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	

}
