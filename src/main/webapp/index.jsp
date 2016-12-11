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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>电子商城</title>
<link href="./css/slider.css" rel="stylesheet" type="text/css" />
<link href="./css/common.css" rel="stylesheet" type="text/css" />
<link href="./css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%@ include file="header.jsp"%>
	<div class="container index">
		<div class="span24">
			<div class="hotProduct clearfix">
				<div class="title">
					<strong>热门商品</strong>
				</div>
				<ul class="tab"></ul>
				<ul class="tabContent">
					<s:iterator value="[0].top" var="hotGood">
						<li><s:a action="good_detail" namespace="/">
								<s:param name="id" value="%{#hotGood.id}" />
								<img alt="<s:property value="%{#hotGood.name}" />"
									style="display: block;"
									src="${ pageContext.request.contextPath }<s:property value='%{#hotGood.image}' />">
							</s:a> <s:property value="%{#hotGood.id}" />&nbsp; <s:property
								value="%{#hotGood.name}" />&nbsp; <s:text
								name="global.format.money">
								<s:param value="%{#hotGood.price}" />
							</s:text>&nbsp; <s:property value='%{#hotGood.isHot}' /><br /> <s:text name="global.format.datetime"><s:param value="%{#hotGood.time}"/></s:text></li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong>
				</div>
				<ul class="tab"></ul>
				<ul class="tabContent">
					<s:iterator value="[1].top" var="newGood">
						<li><s:a action="good_detail" namespace="/">
								<s:param name="id" value="%{#newGood.id}" />
								<img alt="<s:property value="%{#newGood.name}" />"
									style="display: block;"
									src="${ pageContext.request.contextPath }<s:property value='%{#newGood.image}' />">
							</s:a> <s:property value="%{#newGood.id}" />&nbsp; <s:property
								value="%{#newGood.name}" />&nbsp; <s:text
								name="global.format.money">
								<s:param value="%{#newGood.price}" />
							</s:text>&nbsp; <s:property value='%{#newGood.isHot}' /><br /> <s:text name="global.format.datetime"><s:param value="%{#newGood.time}"/></s:text></li>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>