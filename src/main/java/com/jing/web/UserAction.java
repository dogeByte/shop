package com.jing.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jing.service.UserService;
import com.jing.utils.CookieUtils;
import com.jing.utils.Md5Utils;
import com.jing.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>, SessionAware {

	private static final long serialVersionUID = -5281837144186871707L;
	private User user = new User();
	private Map<String, Object> session;
	private UserService userService;
	private String autoLogin;

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	public String login() {
		String username = user.getUsername();
		String password = user.getPassword();
		user = userService.findByUsernameAndPassword(username, password);
		if (user == null || user.getId() == null) {
			this.addActionError("用户名或密码错误");
			return "loginFailure";
		}
		session.put("user", user);
		if ("自动登录".equals(autoLogin)) {
			try {
				username = URLEncoder.encode(username, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			password = Md5Utils.md5(password);
			Cookie cookie = new Cookie("autoLogin", username + "::" + password);
			cookie.setMaxAge(365 * 24 * 60 * 60);
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);
		} else {
			CookieUtils.delete("autoLogin");
		}
		return "loginSuccess";
	}

	public String logout() {
		session.remove("user");
		CookieUtils.delete("autoLogin");
		return "logoutSuccess";
	}
	
}
