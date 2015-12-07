<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>手机实时报警定位系统登录页面</title>
<jsp:include page="include.jsp"></jsp:include>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}

.STYLE1 {
	color: #E6EBF1
}
-->
</style>
<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table width="100%" height="166" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="42" valign="top"><table width="100%" height="42"
					border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
					<tr>
						<td width="1%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="17%">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td valign="top"><table width="100%" height="532" border="0"
					cellpadding="0" cellspacing="0" class="login_bg">
					<tr>
						<td width="49%" align="right"><table width="91%" height="532"
								border="0" cellpadding="0" cellspacing="0" class="login_bg2">
								<tr>
									<td height="138" valign="top"><table width="89%"
											height="427" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td height="149">&nbsp;</td>
											</tr>
											<tr>
												<td height="80" align="right" valign="top">&nbsp;</td>
											</tr>
											<tr>
												<td height="198" align="right" valign="top">
													<div class="panel panel-primary">
														<div class="panel-heading">
															<h1 class="panel-title"><strong>手机实时定位报警系统</strong></h1>
														</div>
														<div class="panel-body">
															<table width="100%" border="0" cellpadding="0"
														cellspacing="0">
													
														<tr>
															<td width="5%">&nbsp;</td>
															<td width="95%" height="25" class="left_txt"><p>
															   1-实时显示报警人位置信息 </p></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" class="left_txt"><p>2- 查看报警信息</p></td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" class="left_txt"><p>3- 查询用户资料</p></td>
														</tr>
													</table>
														</div>
													</div>
													
												</td>
											</tr>
										</table></td>
								</tr>

							</table></td>
						<td width="1%">&nbsp;</td>
						<td width="50%" valign="bottom"><table width="100%"
								height="59" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="4%">&nbsp;</td>

								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="21"><table cellSpacing="0" cellPadding="0"
											width="100%" border="0" id="table211" height="328">
											<tr>
												<td height="164" colspan="2" align="middle">
													<div class="container">

														<div class="col-md-offset-4 col-md-4">
															<div class="panel panel-primary">
																<div class="panel-heading">请登陆</div>
																<div class="panel-body">
																	<p>																	
																		<FONT color="red">${tip}</FONT>
																	</p>

																	<p>
																		<FONT color="red"><s:actionerror /></FONT>
																		<!--显示错误信息 -->
																	</p>
																	<form id="LoginAction" name="LoginAction"
																		action="loginAction.action" method="post"
																		enctype="multipart/form-data">
																		<div class="form-group">
																			<label for="LoginAction_userName">管理员名:</label> <input
																				class="form-control" name="adminName" value=""
																				id="LoginAction_userName" type="text">
																		</div>
																		<div class="form-group">
																			<label for="LoginAction_password">密码:</label> <input
																				class="form-control" name="password"
																				id="LoginAction_password" type="password">
																		</div>
																		<input class="btn btn-primary" id="LoginAction_0"
																			value="登陆" type="submit">
																	</form>
																</div>
															</div>
														</div>



													</div> <%-- <form name="myform" action="loginAction.action" method="post">
	                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
	                          <tr>
	                          	<td colspan="2"><FONT color="red"><s:actionerror/></FONT></td><!--显示错误信息 --> 
	                          </tr>
	                          <tr>
	                            <td width="14%" height="38" class="top_hui_text"><span class="login_txt">管理员名：&nbsp;&nbsp; </span></td>
	                            <td height="38" colspan="2" class="top_hui_text"><input name="adminName" class="editbox4" value="" size="20">                            </td>
	                          </tr>
	                          <tr>
	                            <td width="14%" height="35" class="top_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
	                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" type="password" size="20" name="password">
	                              <img src="images/luck.gif" width="19" height="18"> </td>
	                          </tr>
	                      
	                          <tr>
	                            <td height="35" >&nbsp;</td>
	                            <td width="19%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 录"> </td>
	                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="showConfirmMsg1()"></td>
	                          </tr>
	                        </table>
	                        <br>
	                    </form> --%>
												</td>
											</tr>
											<tr>
												<td width="433" height="164" align="right" valign="bottom"><img
													src="images/login-wel.gif" width="242" height="138"></td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="20">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="login-buttom-bg">
					<tr>
						<td align="center"><span class="login-buttom-txt STYLE1">实时定位报警系统Copyright
								&copy; 2014-2015 </span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
