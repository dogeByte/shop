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
<title>商品列表</title>
</head>
<body>

	<s:debug />
	<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray"
		border="1"
		style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
		<tr>
			<th>编号</th>
			<th>图片</th>
			<th>名称</th>
			<th>价格</th>
			<th>分类</th>
			<th>描述</th>
			<th>更新时间</th>
			<th>操作</th>
		</tr>
		<s:iterator value="%{page.beans}" var="good">
			<tr align="center">
				<td><s:property value="%{#good.id}" /></td>
				<td><img width="40" height="40"
					alt="<s:property value='%{#good.name}' />"
					src="${ pageContext.request.contextPath }<s:property value='%{#good.image}' />" /></td>
				<td><s:property value="%{#good.name}" /></td>
				<td><s:text name="global.format.money">
						<s:param value="%{#good.price}" />
					</s:text></td>
				<td><s:property value="%{#good.category2.category1.name}" />&nbsp;-&nbsp;<s:property
						value="%{#good.category2.name}" /></td>
				<td><s:property value="%{#good.description}" /></td>
				<td><s:date name="%{#good.time}" format="yyyy/MM/dd HH:mm:SS" /></td>
				<td><s:a action="good_updatePage" namespace="/">
						<img src="${pageContext.request.contextPath}/images/i_edit.gif" />
						<s:param name="id" value="%{#good.id}" />
						<s:param name="currentPage" value="%{page.currentPage}" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a>&nbsp;<s:a action="good_delete" namespace="/" onclick="del(event)">
						<img src="${pageContext.request.contextPath}/images/i_del.gif" />
						<s:param name="id" value="%{#good.id}" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a></td>
			</tr>
		</s:iterator>
		<tr align="center">
			<td colspan="8"><s:if test="%{page.currentPage != 1}">
					<s:a action="good_showPage" namespace="/">首页
					<s:param name="currentPage" value="1" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a>&nbsp;&nbsp;<s:a action="good_showPage" namespace="/">上一页
					<s:param name="currentPage" value="%{page.currentPage - 1}" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a>
				</s:if> <s:else>
				首页&nbsp;&nbsp;上一页
			</s:else>&nbsp;<s:property value="%{page.currentPage}" />/<s:property
					value="%{page.totalPage}" />&nbsp;<s:if
					test="%{page.currentPage != page.totalPage}">
					<s:a action="good_showPage" namespace="/">下一页
					<s:param name="currentPage" value="%{page.currentPage + 1}" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a>&nbsp;&nbsp;<s:a action="good_showPage" namespace="/">尾页
					<s:param name="currentPage" value="%{page.totalPage}" />
						<s:param name="limit" value="%{page.limit}" />
					</s:a>
				</s:if> <s:else>
				下一页&nbsp;&nbsp;尾页
				</s:else>&nbsp;&nbsp;&nbsp;&nbsp; <s:if test="%{page.limit == 5}">
				5</s:if> <s:else>
					<s:a action="good_showPage" namespace="/">5
					<s:param name="currentPage" value="1" />
						<s:param name="limit" value="5" />
					</s:a>
				</s:else> <s:if test="%{page.limit == 10}"> 10</s:if> <s:else>
					<s:a action="good_showPage" namespace="/">10
					<s:param name="currentPage" value="1" />
						<s:param name="limit" value="10" />
					</s:a>
				</s:else> <s:if test="%{page.limit == 20}">
				20</s:if> <s:else>
					<s:a action="good_showPage" namespace="/">20
					<s:param name="currentPage" value="1" />
						<s:param name="limit" value="20" />
					</s:a>
				</s:else></td>
		</tr>
	</table>
	<br />
</body>
<script type="text/javascript">
	function del(e) {
		if (!window.confirm("确认删除？")) {
			if (e && e.preventDefault) {
				e.preventDefault();
			} else {
				window.event.returnValue = false;
			}
		}
	}
</script>
</html>