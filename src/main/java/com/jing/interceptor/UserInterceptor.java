package com.jing.interceptor;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jing.utils.CookieUtils;
import com.jing.vo.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = -9107838572191157408L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if (user != null && user.getId() != null) {
			return invocation.invoke();
		}
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		Cookie cookie = CookieUtils.getCookieByName(cookies, "autoLogin");
		ActionSupport action = (ActionSupport) invocation.getAction();
		if (cookie == null || cookie.getValue() == null || !cookie.getValue().contains("::")) {
			action.addActionError("请先登录");
			return "userPrivilegeFailure";
		}
		String[] value = cookie.getValue().split("::");
		String username = URLDecoder.decode(value[0], "utf-8");
		String password = value[1];
		user = this.verify(username, password);
		if (user == null || user.getId() == null) {
			action.addActionError("请先登录");
			return "userPrivilegeFailure";
		}
		session.setAttribute("user", user);
		return invocation.invoke();
	}

	// 用户校验
	private User verify(String username, String password) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));
			@SuppressWarnings("unchecked")
			List<User> users = criteria.list();
			User user = (users == null || users.size() == 0) ? null : users.get(0);
			tx.commit();
			return user;
		}
	}

}
