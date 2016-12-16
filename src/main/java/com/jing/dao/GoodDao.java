package com.jing.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.utils.DaoUtils;
import com.jing.vo.Good;
import com.jing.vo.Page;

public class GoodDao extends HibernateDaoSupport {

	public void add(Good good) {
		this.getHibernateTemplate().save(good);
	}

	public void update(Good good) {
		this.getHibernateTemplate().update(good);
	}

	@SuppressWarnings("unchecked")
	public List<Good> findByPage(Page<Good> page) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Good.class);
		Integer maxResults = page.getLimit();
		Integer firstResult = (page.getCurrentPage() - 1) * maxResults;
		return this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	// 所有商品的总数
	public Integer findCount() {
		return DaoUtils.findCountBySql(this.getHibernateTemplate(), "select count(*) from Good");
	}

	public Good findById(Integer id) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Good where id=?", id);
	}

	public void delele(Good good) {
		this.getHibernateTemplate().delete(good);
	}

	@SuppressWarnings("unchecked")
	public List<Good> findHot() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Good.class);
		criteria.add(Restrictions.eq("isHot", 1));
		criteria.addOrder(Order.desc("time"));
		return this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
	}



	@SuppressWarnings("unchecked")
	public List<Good> findByCategory1IdAndPage(Integer category1Id, Page<Good> page) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Good.class, "g");
		criteria.createAlias("category2", "c2");
		criteria.add(Restrictions.eqProperty("g.category2.id", "c2.id"));
		criteria.add(Restrictions.eq("c2.category1.id", category1Id));
		Integer maxResults = page.getLimit();
		Integer firstResult = (page.getCurrentPage() - 1) * maxResults;
		return this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	public Integer findCountByCategory1Id(Integer category1Id) {
		return DaoUtils.findCountBySql(this.getHibernateTemplate(),
				"select count(*) from Good g join g.category2 c2 join c2.category1 c1 where c1.id=?", category1Id);
	}
	
	
	public Integer findCountByCategory2Id(Integer category2Id) {
		return DaoUtils.findCountBySql(this.getHibernateTemplate(),
				"select count(*) from Good where category2.id=?", category2Id);
	}

}
