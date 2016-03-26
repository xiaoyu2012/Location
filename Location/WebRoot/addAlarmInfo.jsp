<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:include page="include.jsp"></jsp:include>
    <title>My JSP 'addAlarmInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form cssClass="form"  action="addAlarmInfoAction" enctype="multipart/form-data" method="post" theme="simple">    
    	<div class="form-group">
    			<!-- <label for="userId">用户id</label> -->
				<s:textarea cssClass="form-control" name="userId" placeholder="用户id" />
		</div>
		<div class="form-group">
				<s:textarea cssClass="form-control" name="longitude" placeholder="经度" />
		</div>  
		<div class="form-group">
				<s:textarea cssClass="form-control" name="latitude" placeholder="纬度" />
		</div> 
		<div class="form-group">
				<s:textarea cssClass="form-control" name="radius" placeholder="定位范围" />
		</div>        	
    	<s:submit cssClass="btn btn-primary" value="提交" />  
	</s:form> 
  </body>
</html>
