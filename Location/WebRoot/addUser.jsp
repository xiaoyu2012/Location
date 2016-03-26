
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="include.jsp"></jsp:include>
<title>'addUser.jsp'</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->

</head>

<body>
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">

						<form role="form" action="addUserAction" method="post" 
							class="registration-form">

							<fieldset>
								<div class="form-top">
									<div class="form-top-left">
										<h3>注册</h3>			
										<p>请输入用户相关信息   </p>							
									</div>
									<div class="form-top-right">
										<i class="fa fa-user"></i>
									</div>
								</div>
								<div class="form-bottom">
									<div class="form-group">
										<label class="sr-only" for="userName">userName</label>
										 <input type="text" name="userName"
											placeholder="用户名..."
											class="form-control" id="userName">
									</div>
									<div class="form-group">
										<label class="sr-only" for="password">password</label>
										<input type="password" name="password"
											placeholder="密码..."
											class="form-control" id="password">
									</div>
									<div class="form-group">
										<label class="sr-only" for="tel">tel</label>
										<input name="tel"
											placeholder="手机号..."
											class="form-control"
											id="tel"></input>
									</div>
									
									<div class="form-group">
										<label class="sr-only" for="sex">sex</label>
										<input name="sex"
											placeholder="性别..."
											class="form-control"
											id="sex"></input>
									</div>
									
									<div class="form-group">
										<label class="sr-only" for="age">age</label>
										<input name="age"
											placeholder="年龄..."
											class="form-control"
											id="age"></input>
									</div>
									
									<div class="form-group">
										<label class="sr-only" for="emergencyName">emergencyName</label>
										<input name="emergencyName"
											placeholder="紧急联系人姓名..."
											class="form-control"
											id="emergencyName"></input>
									</div>
									
									<div class="form-group">
										<label class="sr-only" for="emergencyTel">emergencyTel</label>
										<input name="emergencyTel"
											placeholder="紧急联系人电话..."
											class="form-control"
											id="emergencyTel"></input>
									</div>
									<button type="submit" class="btn btn-primary">注册</button>
									 
								</div>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
