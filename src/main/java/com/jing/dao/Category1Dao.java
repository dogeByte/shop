package com.jing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.vo.Category1;

public class Category1Dao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Category1> findAll() {
		return this.getHibernateTemplate().find("from Category1");
	}

}
