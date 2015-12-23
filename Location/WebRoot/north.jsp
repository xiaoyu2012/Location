<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div><img src="pic/title.png" alt="Location System" height="70" width="1920"> </div>

<div style="position: absolute; right: 0px; bottom: 0px;"> 
	<span class="label label-primary">${sessionScope.adminName}</span> 已登录 
	<s:a cssClass="btn btn-default" href="loginAction!exit.action">退出系统</s:a>
</div>


