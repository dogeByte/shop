package com.jing.web;

import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jing.utils.CaptchaUtils;
import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7762096393800214493L;
	private Map<String, Object> session;
	private String captcha;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String create() {
		try {
			captcha = CaptchaUtils.create(ServletActionContext.getResponse().getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("验证码生成失败");
		}
		session.put("captcha", captcha);
		return NONE;
	}

	public String verify() {
		String captchaReal = (String) session.get("captcha");
		try {
			ServletActionContext.getResponse().getWriter()
					.print(captcha.toLowerCase().equals(captchaReal.toLowerCase()));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("验证码校验失败");
		}
		return NONE;
	}

}
