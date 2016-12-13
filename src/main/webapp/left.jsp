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

	<div class="span6">
		<div class="hotProductCategory">
			<s:iterator value="[0].top" var="category1">
				<dl>
					<dt>
						<s:a action="good_listByCategory1IdPage" namespace="/">
							<s:property value="%{#category1.name}" />
							<s:param name="category1Id" value="%{#category1.id}" />
							<s:param name="currentPage" value="1" />
						</s:a>
					</dt>
					<s:iterator value="%{#category1.category2s}" var="category2">
						<dd>
							<s:a action="good_listByCategory2IdPage" namespace="/">
								<s:property value="%{#category2.name}" />
								<s:param name="category2Id" value="%{#category2.id}" />
								<s:param name="currentPage" value="1" />
							</s:a>
						</dd>
					</s:iterator>
				</dl>
			</s:iterator>
		</div>
	</div>

</body>
</html>