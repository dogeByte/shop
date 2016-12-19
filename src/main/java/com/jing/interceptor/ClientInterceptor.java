package com.jing.interceptor;

import org.apache.struts2.ServletActionContext;

import com.jing.vo.Client;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class ClientInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -6145883264158160248L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Client client = (Client) ServletActionContext.getRequest().getSession().getAttribute("client");
		if (client == null || client.getId() == null) {
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("请先登录");
			return "clientPrivilegeFailure";
		}
		return invocation.invoke();
	}

}
