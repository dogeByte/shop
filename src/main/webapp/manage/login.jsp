<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<script type="text/javascript">
	if (top.location != window.location) {
		top.location = window.location;
	}
</script>
<title>后台登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/css/general.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css"
	rel="stylesheet" type="text/css" />

<style type="text/css">
body {
	color: white;
}
</style>
<body style="background: #278296">
	<s:form action="user_login" namespace="/" method="post" theme="simple">
		<table style="margin-top: 100px" align="center">
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:password name="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><s:checkboxlist name="autoLogin" list="%{'自动登录'}"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><s:submit value="进入管理中心" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">&raquo;&nbsp;<s:a action="index"
						namespace="/" style="color:white">返回首页</s:a>&nbsp;&nbsp;&nbsp;&nbsp;&raquo;&nbsp;<a
					href="javascript:void(0)" style="color:white">找回密码</a></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><font color="red"><s:actionerror /></font></td>
			</tr>
		</table>
	</s:form>

</body>

</html>