package com.jing.utils;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class DaoUtils {

	public static <T> T findBySql(HibernateTemplate ht, String sql, Object... params) {
		@SuppressWarnings("unchecked")
		List<T> ts = ht.find(sql, params);
		return (ts.size() == 0) ? null : ts.get(0);
	}

	public static Integer findCountBySql(HibernateTemplate ht, String sql, Object... params) {
		@SuppressWarnings("unchecked")
		List<Long> counts = ht.find(sql, params);
		return (counts.size() == 0) ? null : counts.get(0).intValue();
	}

}
