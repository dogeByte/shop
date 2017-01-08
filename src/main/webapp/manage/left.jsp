<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Left</title>
<link href="${pageContext.request.contextPath}/css/left.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="dtree">
		<a href="javascript:d.openAll();">展开所有</a> | <a
			href="javascript:d.closeAll();">关闭所有</a>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree.js"></script>
<script type="text/javascript">
	d = new dTree("d");
	d.add(0, -1, "后台管理系统");
	d.add(1, 0, "用户管理");
	d.add(11, 1, "查看用户", "${pageContext.request.contextPath}/client_show", "", "mainFrame");
	d.add(2, 0, "分类管理");
	d.add(21, 2, "一级分类", "javascript:void(0)", "", "mainFrame");
	d.add(22, 2, "二级分类", "javascript:void(0)", "", "mainFrame");
	d.add(3, 0, "商品管理");
	d.add(31, 3, "查看商品", "${pageContext.request.contextPath}/good_showPage?currentPage=1&limit=10", "", "mainFrame");
	d.add(32, 3, "添加商品", "${pageContext.request.contextPath}/good_addPage", "", "mainFrame");
	d.add(4, 0, "订单管理");
	d.add(41, 4, "查看订单", "${pageContext.request.contextPath}/order_findAll", "", "mainFrame");
	document.write(d);
</script>
</html>