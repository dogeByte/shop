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
<style>
body {
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-BASE-COLOR: #dee3f7;
}
</style>
<title>后台管理</title>
</head>
<frameset rows="103,*,43" frameborder="no" border="0" framespacing="0">
	<frame src="${pageContext.request.contextPath}/manage/top.jsp"
		name="topFrame" scrolling="no" noresize>
	<frameset cols="159,*" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/manage/left.jsp"
			name="leftFrame" noresize scrolling="yes">
		<frame name="mainFrame">
	</frameset>
	<frame src="${pageContext.request.contextPath}/manage/bottom.jsp"
		name="bottomFrame" scrolling="no" noresize>
</frameset>
</html>