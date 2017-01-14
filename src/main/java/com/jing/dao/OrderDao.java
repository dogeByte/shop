package com.jing.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.utils.DaoUtils;
import com.jing.vo.Order;

public class OrderDao extends HibernateDaoSupport {

	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
	
	public void update(Order order) {
		this.getHibernateTemplate().update(order);
	}

	@SuppressWarnings("unchecked")
	public List<Order> findByClientId(Integer clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class, "o");
		criteria.add(Restrictions.eq("o.client.id", clientId));
		criteria.addOrder(org.hibernate.criterion.Order.desc("time"));
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	public Order findById(Integer id) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Order where id=?", id);
	}

	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		return this.getHibernateTemplate().find("from Order");
	}

	@SuppressWarnings("unchecked")
	public List<Order> findByCriteria(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

}
