package com.jing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.vo.Category2;

public class Category2Dao extends HibernateDaoSupport {

	private Category2 findByHQL(String hql, Object... params) {
		@SuppressWarnings("unchecked")
		List<Category2> category2s = this.getHibernateTemplate().find(hql, params);
		if (category2s == null || category2s.size() == 0) {
			return null;
		}
		return category2s.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Category2> findCategory2sByCategory1Id(Integer category1Id) {
		return this.getHibernateTemplate().find("from Category2 where c1no=?", category1Id);
	}

	public Category2 findCategory2ById(Integer category2Id) {
		this.getHibernateTemplate().clear();
		return this.findByHQL("from Category2 where id=?", category2Id);
	}

}
