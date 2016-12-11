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
<title>用户注册</title>
<link href="${ pageContext.request.contextPath }/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/css/register.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员注册</strong>
					</div>
					<s:form action="client_register" namespace="/" method="post"
						onsubmit="return verify()" theme="simple">
						<table>
							<tbody>
								<tr>
									<th><span class="requiredField">*</span>用户名:</th>
									<td><s:textfield id="username" name="username"
											cssClass="text" /><span id="usernameSpan"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>密码:</th>
									<td><s:password id="password" name="password"
											cssClass="text" /><span id="passwordSpan"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>确认密码:</th>
									<td><s:password id="repassword" cssClass="text" /><span
										id="repasswordSpan"></span></td>
								</tr>
								<tr>
								<tr>
									<th><span class="requiredField">*</span>邮箱:</th>
									<td><s:textfield id="email" name="email" cssClass="text" /><span
										id="emailSpan"></span></td>
								</tr>
								<tr>
									<th>姓名:</th>
									<td><s:textfield id="name" name="name" cssClass="text" /></td>
								</tr>
								<tr>
									<th>性别:</th>
									<td><s:radio list="{'男','女'}" name="gender" value="'男'" /></td>
								</tr>
								<tr>
									<th>联系电话:</th>
									<td><s:textfield id="phone" name="phone" cssClass="text" /><span
										id="phoneSpan"></span></td>
								</tr>
								<tr>
									<th>收货地址:</th>
									<td><s:textfield id="address" name="address"
											cssClass="text" /></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>验证码:</th>
									<td><s:textfield id="captchaText" name="captcha"
											cssClass="text" style="width:115px" /> <img alt="验证码"
										src="${pageContext.request.contextPath}/captcha_create"
										id="captchaImg" onclick="refreshCaptcha()" /><span
										id="captchaSpan"></span></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><s:submit class="submit" value="同意以下协议并注册" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><font color="red"><s:fielderror /> <s:actionerror /></font></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>注册协议</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>
										<div id="agreement" class="agreement"
											style="width:520px;height:100px;">
											<p>尊敬的用户，欢迎您注册成为本网站会员。请用户仔细阅读以下全部内容。如用户不同意本服务条款任意内容，请不要注册或使用本网站服务。如用户通过本网站注册程序，即表示用户与本网站已达成协议，自愿接受本服务条款的所有内容。此后，用户不得以未阅读本服务条款内容作任何形式的抗辩。</p>
											<p>
												一、本站服务条款的确认和接纳<br>本网站涉及的各项服务的所有权和运作权归本网站所有。本网站所提供的服务必须按照其发布的服务条款和操作规则严格执行。本服务条款的效力范围及于本网站的一切产品和服务，用户在享受本网站的任何服务时，应当受本服务条款的约束。
											</p>
											<p>
												二、服务简介<br>本网站运用自己的操作系统通过国际互联网络为用户提供各项服务。用户必须: 1.
												提供设备，如个人电脑、手机或其他上网设备。 2. 个人上网和支付与此服务有关的费用。
											</p>
											<p>
												三、用户在不得在本网站上发布下列违法信息<br>1. 反对宪法所确定的基本原则的； 2.
												危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的； 3. 损害国家荣誉和利益的； 4.
												煽动民族仇恨、民族歧视，破坏民族团结的； 5. 破坏国家宗教政策，宣扬邪教和封建迷信的； 6.
												散布谣言，扰乱社会秩序，破坏社会稳定的； 7. 散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的； 8.
												侮辱或者诽谤他人，侵害他人合法权益的； 9. 含有法律、行政法规禁止的其他内容的。
											</p>
											<p>
												四、有关个人资料<br>用户同意: 1. 提供及时、详尽及准确的个人资料。 2. 同意接收来自本网站的信息。
												3. 不断更新注册资料，符合及时、详尽准确的要求。所有原始键入的资料将引用为注册资料。 4.
												本网站不公开用户的姓名、地址、电子邮箱和笔名。除以下情况外: a) 用户授权本站透露这些信息。 b)
												相应的法律及程序要求本站提供用户的个人资料。
											</p>
											<p>
												五、服务条款的修改<br>本网站有权在必要时修改服务条款，一旦条款及服务内容产生变动，本网站将会在重要页面上提示修改内容。如果不同意所改动的内容，用户可以主动取消获得的本网站信息服务。如果用户继续享用本网站信息服务，则视为接受服务条款的变动。
											</p>
											<p>
												六、用户隐私制度<br>尊重用户个人隐私是本网站的一项基本政策。所以，本网站一定不会在未经合法用户授权时公开、编辑或透露其注册资料及保存在本网站中的非公开内容，除非有法律许可要求或本网站在诚信的基础上认为透露这些信息在以下四种情况是必要的:
												1. 遵守有关法律规定，遵从本网站合法服务程序。 2. 保持维护本网站的商标所有权。 3.
												在紧急情况下竭力维护用户个人和社会大众的隐私安全。 4. 符合其他相关的要求。
											</p>
											<p>
												七、用户的帐号、密码和安全性<br>用户一旦注册成功，将获得一个密码和用户名。用户需谨慎合理的保存、使用用户名和密码。如果你不保管好自己的帐号和密码安全，将负全部责任。另外，每个用户都要对其帐户中的所有活动和事件负全责。你可随时根据指示改变你的密码。用户若发现任何非法使用用户帐号或存在安全漏洞的情况，请立即通告本网站。
												八、 拒绝提供担保
												用户明确同意信息服务的使用由用户个人承担风险。本网站不担保服务不会受中断，对服务的及时性，安全性，出错发生都不作担保，但会在能力范围内，避免出错。
											</p>
											<p>
												九、有限责任<br>如因不可抗力或其它本站无法控制的原因使本站销售系统崩溃或无法正常使用导致网上交易无法完成或丢失有关的信息、记录等本站会尽可能合理地协助处理善后事宜，并努力使客户免受经济损失，同时会尽量避免这种损害的发生。
											</p>
											<p>
												十、用户信息的储存和限制<br>本站有判定用户的行为是否符合国家法律法规规定及本站服务条款权利，如果用户违背本网站服务条款的规定，本网站有权中断对其提供服务的权利。
											</p>
											<p>
												十一、用户管理<br>用户单独承担发布内容的责任。用户对服务的使用是根据所有适用于本站的国家法律、地方法律和国际法律标准的。用户必须遵循:
												1. 使用网络服务不作非法用途。 2. 不干扰或混乱网络服务。 3. 遵守所有使用网络服务的网络协议、规定、程序和惯例。
												用户须承诺不传输任何非法的、骚扰性的、中伤他人的、辱骂性的、恐性的、伤害性的、庸俗的，淫秽等信息资料。另外，用户也不能传输何教唆他人构成犯罪行为的资料；不能传输助长国内不利条件和涉及国家安全的资料；不能传输任何不符合当地法规、国家法律和国际法律的资料。未经许可而非法进入其它电脑系统是禁止的。
												若用户的行为不符合以上提到的服务条款，本站将作出独立判断立即取消用户服务帐号。用户需对自己在网上的行为承担法律责任。用户若在本站上散布和传播反动、色情或其它违反国家法律的信息，本站的系统记录有可能作为用户违反法律的证据。
											</p>
											<p>
												十二、通告<br>所有发给用户的通告都可通过重要页面的公告或电子邮件或常规的信件传送。服务条款的修改、服务变更、或其它重要事件的通告都会以此形式进行。
											</p>
											<p>
												十三、信息内容的所有权<br>本网站定义的信息内容包括:
												文字、软件、声音、相片、录像、图表；在广告中全部内容；本网站为用户提供的其它信息。所有这些内容受版权、商标、标签和其它财产所有权法律的保护。所以，用户只能在本网站和广告商授权下才能使用这些内容，而不能擅自复制、再造这些内容、或创造与内容有关的派生产品。本站所有的文章版权归原文作者和本站共同所有，任何人需要转载本站的文章，必须征得原文作者或本站授权。
											</p>
											<p>
												十四、法律<br>本协议的订立、执行和解释及争议的解决均应适用中华人民共和国的法律。用户和本网站一致同意服从本网站所在地有管辖权的法院管辖。如发生本网站服务条款与中华人民共和国法律相抵触时，则这些条款将完全按法律规定重新解释，而其它条款则依旧保持对用户的约束力。
											</p>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="login">
							<div class="ad">
								<dl>
									<dt>注册后即可享受：</dt>
									<dd>正品保障、正规发票</dd>
									<dd>货到付款、会员服务</dd>
									<dd>自由退换、售后上门</dd>
								</dl>
							</div>
							<dl>
								<dt>已经拥有账号了？</dt>
								<dd>
									立即登录即可体验在线购物！ <a
										href="${ pageContext.request.contextPath }/login.jsp">立即登录</a>
								</dd>
							</dl>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

<script type="text/javascript">

	var f6 = false;

	function refreshCaptcha() {
		f6 = false;
		document.getElementById("captchaImg").src = "${pageContext.request.contextPath}/captcha_create?" + new Date().getTime();
		var captcha = document.getElementById("captchaText").value;
		if (!/^\s*$/.test(captcha)) {
			document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
		}
	}

	document.getElementById("username").onblur = function() {
		var username = document.getElementById("username").value;
		if (!/^[a-zA-Z0-9_\u4e00-\u9fa5]{2,20}$/.test(username)) {
			document.getElementById("usernameSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
		} else {
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var isUsed = eval("(" + xhr.responseText + ")");
					if (isUsed) {
						document.getElementById("usernameSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;用户名已存在</font>";
					} else {
						document.getElementById("usernameSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
					}
				}
			}
			xhr.open("post", "${pageContext.request.contextPath}/client_checkUsername");
			xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			xhr.send("username=" + username);
		}
	}

	document.getElementById("password").onblur = function() {
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		if (!/^[a-zA-Z0-9_]{2,10}$/.test(password)) {
			document.getElementById("passwordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
			if (!/^\s*$/.test(repassword)) {
				if (password == repassword) {
					document.getElementById("repasswordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
				} else {
					document.getElementById("repasswordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;密码不一致</font>";
				}
			}
		} else {
			document.getElementById("passwordSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
			if (!/^\s*$/.test(repassword)) {
				if (password == repassword) {
					document.getElementById("repasswordSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
				} else {
					document.getElementById("repasswordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;密码不一致</font>";
				}
			}
		}
	}

	document.getElementById("repassword").onblur = function() {
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		if (!(/^[a-zA-Z0-9_]{2,10}$/.test(repassword))) {
			document.getElementById("repasswordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
		} else {
			if (password == repassword) {
				document.getElementById("repasswordSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
			} else {
				document.getElementById("repasswordSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;密码不一致</font>";
			}
		}
	}

	document.getElementById("email").onblur = function() {
		var email = document.getElementById("email").value;
		if (/^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/.test(email)) {
			document.getElementById("emailSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
		} else {
			document.getElementById("emailSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
		}
	}

	document.getElementById("phone").onblur = function() {
		var phone = document.getElementById("phone").value;
		if (/^\s*$/.test(phone)) {
			document.getElementById("phoneSpan").innerHTML = "";
		} else {
			if (/^\d*$/.test(phone)) {
				document.getElementById("phoneSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
			} else {
				document.getElementById("phoneSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;格式错误</font>";
			}
		}
	}

	document.getElementById("captchaText").onkeyup = function() {
		var captcha = document.getElementById("captchaText").value;
		if (!/^[a-zA-Z0-9]{4}$/.test(captcha)) {
			document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
		} else {
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				xhr = xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					f6 = eval("(" + xhr.responseText + ")");
					if (f6) {
						document.getElementById("captchaSpan").innerHTML = "<font color='green'>&nbsp;✔</font>";
					} else {
						document.getElementById("captchaSpan").innerHTML = "<font color='red'>&nbsp;✘&nbsp;验证码错误</font>";
					}
				}
			}
			xhr.open("post", "${pageContext.request.contextPath}/captcha_verify");
			xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
			xhr.send("captcha=" + captcha);
		}
	}

	function verify() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		var email = document.getElementById("email").value;
		var phone = document.getElementById("phone").value;
		var f1 = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,20}$/.test(username);
		var f2 = /^[a-zA-Z0-9_]{2,10}$/.test(password);
		var f3 = (/^[a-zA-Z0-9_]{2,10}$/.test(repassword) && (password == repassword));
		var f4 = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/.test(email);
		var f5 = (/^(\d*)?$/.test(phone));
		var flag = f1 && f2 && f3 && f4 && f5 && f6;
		if (!flag) {
			alert("信息输入有误");
		}
		return flag;
	}
</script>

</html>