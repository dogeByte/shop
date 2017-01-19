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
<title>订单列表</title>
</head>
<body>

	<s:debug />

	<s:form action="order_find" namespace="/" method="post" theme="simple">
		<table border="0">
			<tr>
				<td align="right">姓名：</td>
				<td><s:textfield name="name" style="width:300px" /></td>
			</tr>
			<tr>
				<td align="right">联系电话：</td>
				<td><s:textfield name="phone" style="width:300px" /></td>
			</tr>
			<tr>
				<td align="right">收件地址：</td>
				<td><s:textfield name="address" style="width:300px" /></td>
			</tr>
			<tr>
				<td align="right">金额：</td>
				<td><s:textfield name="total" style="width:136px" />&nbsp;-&nbsp;
					<s:textfield name="total2" style="width:137px" /></td>
			</tr>
			<tr>
				<td align="right">支付状态：</td>
				<td><s:radio list="%{#{'0':'未支付','1':'已支付'}}" name="state" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><s:submit value="查询" />&nbsp;<s:reset value="重置" /></td>
			</tr>
		</table>
	</s:form>
	<br />
	<s:if test="%{[0].top == null || [0].top.size == 0}">
		<h2>暂无订单</h2>
	</s:if>
	<s:else>
		<table width="100%" border="1">
			<tr bgcolor="#fafafa">
				<th>用户编号</th>
				<th>用户名</th>
				<th>订单编号</th>
				<th>收件人姓名</th>
				<th>联系电话</th>
				<th>收件地址</th>
				<th>金额</th>
				<th>支付状态</th>
			</tr>
			<s:iterator value="%{[0].top}" var="order">
				<tr align="center">
					<td><s:property value="%{#order.client.id}" /></td>
					<td><s:property value="%{#order.client.username}" /></td>
					<td><s:property value="%{#order.id}" /></td>
					<td><s:property value="%{#order.name}" /></td>
					<td><s:property value="%{#order.phone}" /></td>
					<td><s:property value="%{#order.address}" /></td>
					<td><s:text name="global.format.money">
							<s:param value="%{#order.total}" />
						</s:text></td>
					<td><s:if test="%{#order.state == 1}">
							<font color="green">已支付</font>
						</s:if> <s:else>
							<font color="red">未支付</font>
						</s:else></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
	<br />
</body>
</html>