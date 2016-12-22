package com.jing.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.utils.DaoUtils;
import com.jing.vo.Basket;
import com.jing.vo.Cart;

public class CartDao extends HibernateDaoSupport {

	public Cart findById(Integer id) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Cart where id=?", id);
	}

	public Cart findByBasketId(Integer basketId) {
		return this.findBasketByBasketId(basketId).getCart();
	}

	public Basket findBasketByBasketId(Integer basketId) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Basket where id=?", basketId);
	}

	public Basket findBasketByIdAndGoodId(Integer id, Integer goodId) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Basket where cno=? and gno=?", id, goodId);
	}

	public void delete(Integer basketId) {
		Basket basket = this.findBasketByBasketId(basketId);
		this.getHibernateTemplate().clear();
		this.getHibernateTemplate().delete(basket);
	}

	public void update(Cart cart) {
		this.getHibernateTemplate().update(cart);
	}

}
