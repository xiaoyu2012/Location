<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");   //只对post请求的消息体中的数据起作用
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";
	String longitude = request.getParameter("longitude");
	String latitude = request.getParameter("latitude");
	String address = request.getParameter("address");
	address = new String(address.trim().getBytes("ISO-8859-1"), "utf-8");      //解决get请求中文参数乱码 
	System.out.println(longitude +"," +  latitude + ", " + address);
	
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
}
</style>
  	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=gH8WPUPZhd4dH1WH67UtNwi5"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>  
<title>鼠标测距</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能	
	var map = new BMap.Map("allmap");
	var point = new BMap.Point("<%=longitude%>", "<%=latitude%>");
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
	map.centerAndZoom(point, 15);
	var opts = {
	  width : 200,     // 信息窗口宽度
	  height: 100,     // 信息窗口高度
	  title : "<%=address%>" , // 信息窗口标题
	  enableMessage:true,//设置允许信息窗发送短息
	}
	var infoWindow = new BMap.InfoWindow("<%= "经度： " + longitude + ",纬度：" + latitude%>", opts);  // 创建信息窗口对象
	map.openInfoWindow(infoWindow,point); //开启信息窗口 
		
	map.setCurrentCity("武汉");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	
	/*
	var myDis = new BMapLib.DistanceTool(map);
	 map.addEventListener("load", function() {
		myDis.open(); //开启鼠标测距
		myDis.close();  //关闭鼠标测距大
	}); */
</script>
