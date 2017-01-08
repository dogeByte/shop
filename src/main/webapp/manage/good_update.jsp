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
<title>修改商品信息</title>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<s:debug />
	<s:form action="good_update" namespace="/" method="post"
		enctype="multipart/form-data" theme="simple">
		<s:hidden name="id" value="%{model.id}" />
		<s:hidden name="currentPage" value="%{page.currentPage}" />
		<s:hidden name="limit" value="%{page.limit}" />
		<table width="500px" cellSpacing="1" cellPadding="5" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="5"
					height="26"><strong>修&nbsp;改&nbsp;商&nbsp;品&nbsp;信&nbsp;息</strong></td>
			</tr>
			<tr>
				<td bgColor="#f5fafe" class="ta_01">名称：</td>
				<td bgColor="#ffffff" class="ta_01"><s:textfield name="name"
						value="%{model.name}" /></td>
				<td bgColor="#f5fafe" class="ta_01">价格：</td>
				<td bgColor="#ffffff" class="ta_01"><s:textfield name="price"
						value="%{model.price}" /></td>
				<td bgColor="#ffffff" class="ta_01"><s:radio
						list="%{#{'1':'热门','0':'冷门'}}" name="isHot" value="%{model.isHot}" /></td>
			</tr>
			<tr>
				<td bgColor="#f5fafe" class="ta_01">分类：</td>
				<td bgColor="#ffffff" class="ta_01"><s:select id="category1"
						list="[0].top" listKey="id" listValue="name" headerKey="-1"
						headerValue="一级分类" value="%{model.category2.category1.id}" /><span
					id="category2Span"> <s:select name="category2Id"
							list="[1].top" listKey="id"
							listValue="name" headerKey="-1" headerValue="二级分类"
							value="%{model.category2.id}"></s:select>
				</span></td>
				<td bgColor="#f5fafe" class="ta_01">图片：</td>
				<td bgColor="#ffffff" class="ta_01" colspan="2"><s:file
						name="upload" /></td>
			</tr>
			<tr>
				<td bgColor="#f5fafe" class="ta_01" valign="top">描述：</td>
				<td bgColor="#ffffff" class="ta_01" colspan="4"><s:textarea
						name="description" rows="2" cols="42" value="%{model.description}" /></td>
			</tr>
			<tr align="center">
				<td bgColor="#f5fafe" class="ta_01" colspan="5"><s:submit
						value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit value="重置" /></td>
			</tr>
		</table>
	</s:form>
	<br />
	<s:fielderror />
	<s:actionerror />
	<br />
</body>
<script type="text/javascript">
	document.getElementById("category1").onchange = function() {
		var xhr = null;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var category2s = eval("(" + xhr.responseText + ")");
				var text = "<select name='category2Id'><option value='-1'>二级分类</option>";
				for (var i = 0; i < category2s.length; i++) {
					var category2 = category2s[i];
					text += "<option value='" + category2.id + "'>" + category2.name + "</option>";
				}
				text += "</select>";
				document.getElementById("category2Span").innerHTML = text;
			}
		}
		xhr.open("post", "${pageContext.request.contextPath}/category2_findCategory2sByCategory1Id");
		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		xhr.send("category1Id=" + document.getElementById("category1").value);
	}
</script>
</html>