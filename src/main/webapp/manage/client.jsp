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
<title>用户列表</title>
</head>
<body>

	<s:debug />
	<table width="100%" border="1">
		<tr bgcolor="#fafafa">
			<th>编号</th>
			<th>用户名</th>
			<th>姓名</th>
			<th>性别</th>
			<th>邮箱</th>
			<th>联系电话</th>
			<th>地址</th>
			<th>状态</th>
			<th>已支付金额</th>
			<th>未支付金额</th>
			<th>操作</th>
		</tr>
		<s:iterator value="%{[0].top}" var="client">
			<s:set name="paid" value="0" scope="page" />
			<s:set name="unpaid" value="0" scope="page" />
			<s:iterator value="%{#client.orders}" var="order">
				<s:if test="%{#order.state == 1}">
					<s:set name="paid" value="%{#attr.paid + #order.total}" />
				</s:if>
				<s:else>
					<s:set name="unpaid" value="%{#attr.unpaid + #order.total}" />
				</s:else>
			</s:iterator>
			<tr align="center">
				<td><s:property value="%{#client.id}" /></td>
				<td><s:property value="%{#client.username}" /></td>
				<td><s:property value="%{#client.name}" /></td>
				<td><s:property value="%{#client.gender}" /></td>
				<td><s:property value="%{#client.email}" /></td>
				<td><s:property value="%{#client.phone}" /></td>
				<td><s:property value="%{#client.address}" /></td>
				<td><s:if test="%{#client.state == 1}">已激活</s:if> <s:else>未激活</s:else>
				</td>
				<td><s:text name="global.format.money">
						<s:param value="%{#attr.paid}" />
					</s:text></td>
				<td><s:text name="global.format.money">
						<s:param value="%{#attr.unpaid}" />
					</s:text></td>
				<td><s:a action="order_findByClientId" namespace="/">查看订单
						<s:param name="clientId" value="%{#client.id}" />
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
	<br />
</body>
</html>