package com.jing.web;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jing.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class ManageAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8989696680488887912L;
	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) session.get("user");
		if (user == null || user.getId() == null) {
			return INPUT;
		}
		return SUCCESS;
	}

}
