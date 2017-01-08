<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff;
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000;
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000;
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000;
}
</style>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="100%" height="74px"
				background="${pageContext.request.contextPath}/images/top_100.jpg">
			</td>
		</tr>
		<tr>
			<td height="30px" valign="bottom"
				background="${pageContext.request.contextPath}/images/mis_01.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <script
								language="JavaScript">
								tmpDate = new Date();
								date = tmpDate.getDate();
								month = tmpDate.getMonth() + 1;
								year = tmpDate.getFullYear();
								document.write(year);
								document.write("年");
								document.write(month);
								document.write("月");
								document.write(date);
								document.write("日 ");
							
								myArray = new Array(6);
								myArray[0] = "星期日"
								myArray[1] = "星期一"
								myArray[2] = "星期二"
								myArray[3] = "星期三"
								myArray[4] = "星期四"
								myArray[5] = "星期五"
								myArray[6] = "星期六"
								weekday = tmpDate.getDay();
								if (weekday == 0 | weekday == 6) {
									document.write(myArray[weekday])
								} else {
									document.write(myArray[weekday])
								}
							</script>
						</td>
						<td width="15%">用户名：<s:if test="%{#session.user != null}">
								<font color="blue"><s:property
										value="%{#session.user.username}" /></font>&nbsp;&nbsp;&nbsp;&nbsp;
										<s:a action="user_logout" namespace="/">退出</s:a>
							</s:if>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>