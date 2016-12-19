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
<link href="${ pageContext.request.contextPath }/css/common.css"
	rel="stylesheet" type="text/css">
<link href="${ pageContext.request.contextPath }/css/product.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container productList">
		<%@ include file="left.jsp" %>
		<div class="span18 last">
			<s:if test="%{page.beans == null || page.beans.size == 0}">
				<div align="center">
					<br />
					<h2>暂无商品</h2>
				</div>
			</s:if>
			<s:else>
				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator value="%{page.beans}" var="good">
							<li><s:a action="good_detail" namespace="/">
									<s:param name="id" value="%{#good.id}"/>
									<img width="170px" height="170px"
										style="display: inline-block;"
										src="${ pageContext.request.contextPath }<s:property value='%{#good.image}' />"
										alt="<s:property value='%{#good.name}' />">
									<span style='color:green'> <s:property
											value="%{#good.name}" />
									</span>
									<span class="price"><s:text name="global.format.money"><s:param value="%{#good.price}"/></s:text>
									</span>
								</s:a></li>
						</s:iterator>
					</ul>
				</div>

				<div class="pagination">

					<!-- ↓ 首页/上一页 ↓ -->
					<s:if test="%{page.currentPage == 1}">
						<span class="firstPage">&nbsp;</span>
						<span class="previousPage">&nbsp;</span>
					</s:if>
					<s:else>
						<s:if test="%{#parameters.category1Id == null}">
							<s:a action="good_listByCategory2IdPage" namespace="/"
								cssClass="firstPage">&nbsp;
								<s:param name="category2Id" value="%{#parameters.category2Id}" />
								<s:param name="currentPage" value="1" />
							</s:a>
							<s:a action="good_listByCategory2IdPage" namespace="/"
								cssClass="previousPage">&nbsp;
								<s:param name="category2Id" value="%{#parameters.category2Id}" />
								<s:param name="currentPage" value="%{page.currentPage - 1}" />
							</s:a>
						</s:if>
						<s:else>
							<s:a action="good_listByCategory1IdPage" namespace="/"
								cssClass="firstPage">&nbsp;
								<s:param name="category1Id" value="%{#parameters.category1Id}" />
								<s:param name="currentPage" value="1" />
							</s:a>
							<s:a action="good_listByCategory1IdPage" namespace="/"
								cssClass="previousPage">&nbsp;
								<s:param name="category1Id" value="%{#parameters.category1Id}" />
								<s:param name="currentPage" value="%{page.currentPage - 1}" />
							</s:a>
						</s:else>
					</s:else>
					<!-- ↑ 首页/上一页 ↑ -->

					<!-- ↓ 数字翻页 ↓ -->
					<s:iterator begin="1" step="1" end="%{page.totalPage}" var="p">
						<s:if test="%{page.currentPage == #p}">
							<span class="currentPage"><s:property value="%{#p}" /></span>
						</s:if>
						<s:else>
							<s:if test="%{#parameters.category1Id == null}">
								<s:a action="good_listByCategory2IdPage" namespace="/">
									<s:property value="%{#p}" />
									<s:param name="category2Id" value="%{#parameters.category2Id}" />
									<s:param name="currentPage" value="%{#p}" />
								</s:a>
							</s:if>
							<s:else>
								<s:a action="good_listByCategory1IdPage" namespace="/">
									<s:property value="%{#p}" />
									<s:param name="category1Id" value="%{#parameters.category1Id}" />
									<s:param name="currentPage" value="%{#p}" />
								</s:a>
							</s:else>
						</s:else>
					</s:iterator>
					<!-- ↑ 数字翻页 ↑ -->

					<!-- ↓ 下一页/末页 ↓ -->
					<s:if test="%{page.currentPage == page.totalPage}">
						<span class="nextPage">&nbsp;</span>
						<span class="lastPage">&nbsp;</span>
					</s:if>
					<s:else>
						<s:if test="%{#parameters.category1Id == null}">
							<s:a action="good_listByCategory2IdPage" namespace="/"
								cssClass="nextPage">&nbsp;
								<s:param name="category2Id" value="%{#parameters.category2Id}" />
								<s:param name="currentPage" value="%{page.currentPage + 1}" />
							</s:a>
							<s:a action="good_listByCategory2IdPage" namespace="/"
								cssClass="lastPage">&nbsp;
								<s:param name="category2Id" value="%{#parameters.category2Id}" />
								<s:param name="currentPage" value="%{page.totalPage}" />
							</s:a>
						</s:if>
						<s:else>
							<s:a action="good_listByCategory1IdPage" namespace="/"
								cssClass="nextPage">&nbsp;
								<s:param name="category1Id" value="%{#parameters.category1Id}" />
								<s:param name="currentPage" value="%{page.currentPage + 1}" />
							</s:a>
							<s:a action="good_listByCategory1IdPage" namespace="/"
								cssClass="lastPage">&nbsp;
								<s:param name="category1Id" value="%{#parameters.category1Id}" />
								<s:param name="currentPage" value="%{page.totalPage}" />
							</s:a>
						</s:else>
					</s:else>
					<!-- ↑ 下一页/末页 ↑ -->

				</div>
			</s:else>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>