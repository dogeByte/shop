package com.jing.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jing.service.ClientService;
import com.jing.utils.CookieUtils;
import com.jing.vo.Client;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ClientAction extends ActionSupport implements ModelDriven<Client>, SessionAware {

	private static final long serialVersionUID = -1056530328037950840L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private Client client = new Client();
	private Map<String, Object> session;
	private ClientService clientService;
	private String captcha;
	private String remember;

	@Override
	public Client getModel() {
		return client;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	

	@InputConfig(resultName = "registerFailure")
	public String register() {
		if (!this.verifyCaptcha()) {
			return "registerFailure";
		}
		try {
			clientService.register(client);
		} catch (MessagingException e) {
			e.printStackTrace();
			this.addActionError("邮件发送失败");
			return "registerFailure";
		}
		return "registerSuccess";
	}

	public String checkUsername() throws IOException {
		client = clientService.findByUsername(client.getUsername());
		response.getWriter().print(client != null);
		return NONE;
	}

	public String activate() {
		client = clientService.activate(client.getCode());
		if (client == null || client.getId() == null) {
			return "activateFailure";
		}
		return "activateSuccess";
	}

	@InputConfig(resultName = "loginFailure")
	public String login() {

		// 记住用户名
		if ("记住用户名".equals(remember)) {
			Cookie cookie = null;
			try {
				cookie = new Cookie("username", URLEncoder.encode(client.getUsername(), "utf-8"));
				cookie.setMaxAge(24 * 60 * 60);
				cookie.setPath("/");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.addCookie(cookie);
		} else {
			Cookie cookie = CookieUtils.getCookieByName(request.getCookies(), "username");
			if (cookie != null) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}

		if (!this.verifyCaptcha()) {
			return "loginFailure";
		}

		// 用户名或邮箱均可登录
		if (client.getUsername().contains("@")) {
			client.setEmail(client.getUsername());
			client = clientService.findByEmailAndPassword(client.getEmail(), client.getPassword());
		} else {
			client = clientService.findByUsernameAndPassword(client.getUsername(), client.getPassword());
		}

		if (client == null || client.getId() == null) {
			this.addActionError("用户名或密码错误");
			return "loginFailure";
		}

		if (client.getState() == 0) {
			this.addActionError("账号尚未激活");
			return "loginFailure";
		}

		session.put("client", client);
		return "loginSuccess";
	}

	public String logout() {
		session.remove("client");
		return "logoutSuccess";
	}
	
	public String show() {
		List<Client> clients = clientService.findAll();
		ActionContext.getContext().getValueStack().push(clients);
		return "showSuccess";
	}

}
