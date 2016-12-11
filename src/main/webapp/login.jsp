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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${ pageContext.request.contextPath }/css/common.css" rel="stylesheet" type="text/css">
<link href="${ pageContext.request.contextPath }/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${ pageContext.request.contextPath }/image/login.jpg"
					width="500" height="330">
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<s:form action="client_login" namespace="/" method="post"
						onsubmit="return verify()" theme="simple">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td><s:textfield id="username" name="username"
											cssClass="text" /><span id="usernameSpan"></span></td>
								</tr>
								<tr>
									<th>密码:</th>
									<td><s:password id="password" name="password"
											cssClass="text" /><span id="passwordSpan"></span></td>
								</tr>
								<tr>
									<th>验证码:</th>
									<td><s:textfield id="captchaText" name="captcha"
											cssClass="text" style="width:115px" /> <img alt="验证码"
										src="${pageContext.request.contextPath}/captcha_create"
										id="captchaImg" onclick="refreshCaptcha()" /><span
										id="captchaSpan"></span></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label><s:checkboxlist list="{'记住用户名'}" value="'记住用户名'"
												name="remember" /> </label> <label>&nbsp;&nbsp;&nbsp;&nbsp;<a
											href="javascript:void(0)">找回密码</a>
									</label></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><s:submit value="登录" cssClass="submit" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><font size="3" color="red"><s:fielderror /> <s:actionerror /></font></td>
								</tr>
								<tr class="register">
									<td>&nbsp;</td>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a
													href="${ pageContext.request.contextPath }/register.jsp">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
<script type="text/javascript">

	document.getElementById("username").value = window.decodeURIComponent("${ cookie.username.value }", "utf-8");
	var f6 = false;

	function refreshCaptcha() {
		f6 = false;
		document.getElementById("captchaImg").src = "${pageContext.request.contextPath}/captcha_create?" + new Date().getTime();
		var captcha = document.getElementById("captchaText").value;
		if (!/^\s*$/.test(captcha)) {
			document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
		}
	}

	document.getElementById("captchaText").onkeyup = function() {
		var captcha = document.getElementById("captchaText").value;
		if (!/^[a-zA-Z0-9]{4}$/.test(captcha)) {
			document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
		} else {
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					f6 = eval("(" + xhr.responseText + ")");
					if (f6) {
						document.getElementById("captchaSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
					} else {
						document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
					}
				}
			}
			xhr.open("post", "${pageContext.request.contextPath}/captcha_verify");
			xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			xhr.send("captcha=" + captcha);
		}
	}

	function verify() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var f1 = !/^\s*$/.test(username);
		var f2 = !/^\s*$/.test(password);
		var flag = f1 && f1 && f6;
		if (!flag) {
			alert("信息输入有误");
		}
		return flag;
	}
</script>

</html>