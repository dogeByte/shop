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
<title>收银台</title>
<link href="${ pageContext.request.contextPath }/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/css/cart.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container cart">
		<div class="span24">
			<br />
			<s:if test="%{#session.client == null}">
				<h2>
					<a href="${ pageContext.request.contextPath }/login.jsp">请先登录</a>
				</h2>
			</s:if>
			<s:elseif test="hasActionErrors()">
				<h2>
					支付失败
					<s:actionerror />
				</h2>
			</s:elseif>
			<s:else>
				<h2>
					订单编号：
					<s:property value="%{model.id}" />
					<br /> 支付金额：<font color="red"> <s:text
							name="global.format.money">
							<s:param value="%{model.total}" />
						</s:text></font>
				</h2>
				<br />
				<br />
				请选择支付方式：
				<br />
				<br />
				<div>
					<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"
						checked="checked" /> <img
						src="${pageContext.request.contextPath}/bank_img/bc.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" /> <img
						src="${pageContext.request.contextPath}/bank_img/icbc.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" /> <img
						src="${pageContext.request.contextPath}/bank_img/ccb.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" /> <img
						src="${pageContext.request.contextPath}/bank_img/abc.bmp" /><br />
					<br /> <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />
					<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" /> <img
						src="${pageContext.request.contextPath}/bank_img/pingan.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CEB-NET-B2C" /> <img
						src="${pageContext.request.contextPath}/bank_img/guangda.bmp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" /> <img
						src="${pageContext.request.contextPath}/bank_img/cmb.bmp" />
				</div>
				<br />
				<br />
				<div class="bottom">
					<s:a action="order_pay2" namespace="/" cssClass="submit">立即支付
					<s:param name="id" value="%{model.id}" />
					</s:a>
				</div>
			</s:else>
			<br /> <br />
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>