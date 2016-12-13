<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<body>
	<s:debug />
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<img src="${ pageContext.request.contextPath }/image/logo.png" />
			</div>
		</div>
		<div class="span9">
			<div>
				<img src="${ pageContext.request.contextPath }/image/header.jpg" />
			</div>
		</div>
		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
					<s:if test="%{#session.client == null}">
						<li id="headerLogin" class="headerLogin"
							style="display: list-item;"><a
							href="${ pageContext.request.contextPath }/login.jsp">登录</a>|</li>
						<li id="headerRegister" class="headerRegister"
							style="display: list-item;"><a
							href="${ pageContext.request.contextPath }/register.jsp">注册</a>|</li>
					</s:if>
					<s:else>
						<li id="headerUsername" class="headerUsername"
							style="display: list-item;"><s:property
								value="%{#session.client.username}" /></li>
						<li id="headerLogout" class="headerLogout"
							style="display: list-item;"><s:a action="client_logout"
								namespace="/">[退出]</s:a>|</li>
						<li id="headerLogout" class="headerLogout"
							style="display: list-item;"><s:a action="order_show"
								namespace="/">我的订单</s:a>|</li>
					</s:else>
					<li><a href="javascript:void(0)">会员中心</a>|</li>
					<li><s:a action="manage" namespace="/">后台管理</s:a>|</li>
					<li><a href="javascript:void(0)">关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<s:a action="cart_show">购物车
					<s:param name="id" value="%{#session.client.id}" />
				</s:a>
			</div>
			<div class="phone">
				<strong>客服电话：400-666-8888</strong>
			</div>
		</div>
		<div class="span24">
			<ul class="mainNav" id="category1"></ul>
		</div>
		<div class="span24">
			<div class="tagWrap">
				<ul class="tag">
					<li><a href="javascript:void(0)">热销</a></li>
					<li><a href="javascript:void(0)">最新</a></li>
				</ul>
				<div class="hotSearch">
					热门搜索：&nbsp;<a href="javascript:void(0)">水蜜桃</a> <a
						href="javascript:void(0)">西瓜</a> <a href="javascript:void(0)">紫薯</a>
					<a href="javascript:void(0)">大米</a> <a href="javascript:void(0)">玉米</a>
					<a href="javascript:void(0)">茄子</a> <a href="javascript:void(0)">辣椒</a>
					<a href="javascript:void(0)">圣女果</a> <a href="javascript:void(0)">鱿鱼丝</a>
				</div>
				<div class="search">
					<form id="productSearchForm" method="get">
						<input name="keyword" class="keyword" value="商品搜索" maxlength="30">
						<button type="submit">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/js/header.js"></script>
</html>