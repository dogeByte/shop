package com.jing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.vo.User;

public class UserDao extends HibernateDaoSupport {

	public User findByUsernameAndPassword(String username, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = this.getHibernateTemplate().find("from User where username=? and password=?", username,
				password);
		return (users != null && users.size() > 0) ? users.get(0) : null;
	}

}
