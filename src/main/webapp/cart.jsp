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
<title>购物车</title>
<link href="${ pageContext.request.contextPath }/css/common.css"
	rel="stylesheet" type="text/css">
<link href="${ pageContext.request.contextPath }/css/cart.css"
	rel="stylesheet" type="text/css">
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
			<s:elseif test="%{model == null || model.baskets.size == 0}">
				<h2>购物车为空</h2>
			</s:elseif>
			<s:else>
				<table>
					<tr align="center" bgcolor="#fafafa">
						<td width="70px">购物项编号</td>
						<td width="60px">商品编号</td>
						<td width="100px">图片</td>
						<td width="120px">商品</td>
						<td width="150px">分类</td>
						<td width="100px">价格</td>
						<td width="111px">数量</td>
						<td width="100px">小计</td>
						<td>操作</td>
					</tr>
					<s:bean id="basketComparator"
						name="com.jing.utils.BasketComparator" />
					<s:sort comparator="basketComparator" source="%{model.baskets}">
						<s:iterator var="basket">
							<tr align="center">
								<td><s:property value="%{#basket.id}" /></td>
								<td><s:property value="%{#basket.good.id}" /></td>
								<td><img 
									alt="<s:property value="%{#basket.good.name}" />"
									src="${ pageContext.request.contextPath }<s:property value='%{#basket.good.image}'/>" /></td>
								<td><s:property value="%{#basket.good.name}" /></td>
								<td><s:property
										value="%{#basket.good.category2.category1.name}" />&nbsp;-&nbsp;<s:property
										value="%{#basket.good.category2.name}" /></td>
								<td id="price<s:property value='%{#basket.id}'/>"><s:text
										name="global.format.money">
										<s:param value="%{#basket.good.price}" />
									</s:text></td>

								<td class="quantity"><s:if test="%{#basket.count lte 1}">
										<input type="button" value="-" disabled
											id="minusBtn<s:property value='%{#basket.id}'/>"
											onclick="javascript:minus(<s:property value='%{#basket.id}'/>);" />
									</s:if> <s:else>
										<input type="button" value="-"
											id="minusBtn<s:property value='%{#basket.id}'/>"
											onclick="javascript:minus(<s:property value='%{#basket.id}'/>);" />
									</s:else> <s:textfield name="count" value="%{#basket.count}"
										style="width:45px;" id="num%{#basket.id}"
										onkeyup="digitiling(%{#basket.id})" /> <s:if
										test="%{#basket.count gte 9999}">
										<input type="button" value="+" disabled
											id="plusBtn<s:property value='%{#basket.id}'/>"
											onclick="javascript:plus(<s:property value='%{#basket.id}'/>);" />
									</s:if> <s:else>
										<input type="button" value="+"
											id="plusBtn<s:property value='%{#basket.id}'/>"
											onclick="javascript:plus(<s:property value='%{#basket.id}'/>);" />
									</s:else></td>

								<td id="subtotal<s:property value='%{#basket.id}'/>"><s:text
										name="global.format.money">
										<s:param value="%{#basket.subtotal}" />
									</s:text></td>
								<td><s:a action="cart_delete" namespace="/"
										onclick="del(event);" cssClass="delete">删除
											<s:param name="basketId" value="%{#basket.id}" />
									</s:a></td>
							</tr>
						</s:iterator>
					</s:sort>
				</table>
				<div class="total">
					商品总价：<strong id="total"><s:text name="global.format.money">
							<s:param value="%{model.total}" />
						</s:text></strong>
				</div>
				<div class="bottom">
					<s:a action="cart_clear" cssClass="clear" onclick="delAll(event)">清空购物车
						<s:param name="id" value="%{#session.client.id}" />
					</s:a>
					<a href="${ pageContext.request.contextPath }/orderConfirm.jsp"
						id="submit" class="submit">结算 <s:param name="cartId"
							value="%{#session.client.id}" />
					</a>
				</div>
			</s:else>
			<br /> <br />
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

<script type="text/javascript">

	var max = 9999;

	function update(basketId, count) {
		// 前端更新：数量、加减按钮
		document.getElementById("num" + basketId).value = count;
		document.getElementById("minusBtn" + basketId).disabled = (count <= 1);
		document.getElementById("plusBtn" + basketId).disabled = (count >= max);
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				// 后端更新：小计、总价
				var text = xhr.responseText.split("::");
				document.getElementById("subtotal" + basketId).innerHTML = "￥&nbsp;" + text[0];
				document.getElementById("total").innerHTML = "￥&nbsp;" + text[1];
			}
		}
		xhr.open("post", "${pageContext.request.contextPath}/cart_update");
		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		xhr.send("basketId=" + basketId + "&count=" + count);
	}

	// 减按钮
	function minus(basketId) {
		var count = document.getElementById("num" + basketId).value;
		update(basketId, count - 1);
	}

	// 加按钮
	function plus(basketId) {
		var count = document.getElementById("num" + basketId).value;
		update(basketId, count * 1 + 1);
	}

	// 数值文本框并限制上限
	function digitiling(basketId) {
		var num = document.getElementById("num" + basketId);
		num.value = num.value.replace(/\D/g, "");
		if (num.value < 1) {
			num.value = 1;
		} else if (num.value > max) {
			num.value = max;
		}
		update(basketId, num.value);
	}

	function delAll(e) {
		if (!window.confirm("清空购物车？")) {
			if (e && e.preventDefault) {
				e.preventDefault();
			} else {
				window.event.returnValue = false;
			}
		}
	}

	function del(e) {
		if (!window.confirm("删除？")) {
			if (e && e.preventDefault) {
				e.preventDefault();
			} else {
				window.event.returnValue = false;
			}
		}
	}
</script>

</html>