<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>实时报警定位后台管理系统</title>
<jsp:include page="include.jsp"></jsp:include>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<style>
	 table td
	 {	 	
	 	padding:5px;	 	
	 	height:12px;
	 }
</style>

<body id="mainLayout" class="easyui-layout">

	
	<div data-options="region:'north',href:'north.jsp'"
		style="height: 70px; overflow: hidden;" ></div>
	<div data-options="region:'west',href:'',split:true" title="导航"
		style="width: 150px; padding: 3px;">		
		<div class="easyui-accordion">
			<div title="报警记录" data-options="iconCls:'icon-ok'"
				style="overflow:auto;padding:10px;">
				<li><a onclick="addTab('home','map/location.jsp')">待处理</a></li>
				<!-- <li><a onclick="addTab('ccnu','http://www.ccnu.edu.cn')">CCNU</a></li>				 -->
			</div>
			<div title="查询" data-options="iconCls:'icon-ok'"
				style="padding:10px;">
				<li><a  onclick="addTab('用户信息','showAllUserAction.action')">查询用户信息</a></li>
				<li><a>查询报警信息</a></li>
			</div>
		</div>
		
		<div id="p" class="easyui-panel" title="报警人信息" style="width:100%;height:400px;padding:2px;">
			<table cellpadding="10">
				<tr>
	    			<td> <span class="label label-primary">报警人ID:</span></td> </tr>
	    		<tr>
	    			<td style="border-bottom:1px solid green"> <span id="id" class="label label-info"></span></td></tr>
	    		<tr>
	    			<td> <span class="label label-primary">报警标识号:</span></td> </tr>
	    		<tr>
	    			<td style="border-bottom:1px solid green"> <span id="identify" class="label label-info"></span></td></tr>
	    		<tr>
	    			<td><span class="label label-primary">报警人姓名:</span></td></tr>  
	    		<tr> 
	    			<td style="border-bottom:1px solid green"> <span id="name" class="label label-info"></span></td></tr>    	
	    		<tr>
	    			<td><span class="label label-primary">性别:</span></td></tr>  
	    		<tr> 
	    			<td style="border-bottom:1px solid green"> <span id="sex" class="label label-info"></span></td></tr>    	
	    		
	    		<tr>
	    			<td> <span class="label label-primary">手机号:</span></td></tr>
	    		<tr>
	    			<td style="border-bottom:1px solid green"> <span id="tel" class="label label-info"></span></td></tr>  
	    		<tr>
	    			<td> <span class="label label-primary">紧急联系人姓名:</span></td></tr>	    			
	    		<tr> 	    		
	    			<td style="border-bottom:1px solid green"> <span id="ename" class="label label-info"></span></td></tr>  
	    		<tr>
	    			<td> <span class="label label-primary">紧急联系人手机号:</span></td></tr>
	    		<tr>
	    			<td style="border-bottom:1px solid green"> <span id="etel" class="label label-info"></span></td> </tr>
	    	</table>
	    	
	    	
	    	<button type="submit" class="btn btn-success" onclick="changeState2(alarmInfoId,2);">确定出警  </button>
	    
		</div>
	</div>
	
	<div data-options="region:'east', href:'east.jsp', split:true" style="width: 300px; padding: 3px;"> </div>

	<div data-options="region:'center'" style="overflow: hidden;">
		
	<div id="main_tab" class="easyui-tabs" data-options="tools:'#tab-tools'" >
		<div title="home" data-options="closable:true" >
			<iframe scrolling="yes" frameborder="0"  src="map/location.jsp" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
	<script type="text/javascript">
		function addTab(title, url){
			if ($('#main_tab').tabs('exists', title)){
				$('#main_tab').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#main_tab').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}		
		
		function changeState2(alarmInfoId,state){
			var xhr = getXhr();
			var url = "changeStateAction.action?alarmInfoId=" + alarmInfoId + "&state=" + state;
			xhr.open("get",url, true);	
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
				       var message = xhr.responseText;
				       if(message == "0"){
				    	   alert("请重试！");
				       }else{
				    	   alert("处理成功！");
				       }
				       
				   	}
				}
			};
			
			xhr.send(null);
	}
	</script>


	<div
		data-options="region:'south',href:'south.jsp',border:false"
		style="height: 30px; overflow: hidden;"></div>
	

</body>
</html>
