package com.jing.service;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.OrderDao;
import com.jing.vo.Basket;
import com.jing.vo.Order;
import com.jing.vo.OrderItem;

@Transactional
public class OrderService {

	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	// 把购物项中的内容复制到订单项
	public Order add(Order order) {
		for (Basket basket : order.getClient().getCart().getBaskets()) {
			OrderItem orderItem = new OrderItem(basket.getCount(), order, basket.getGood(), basket.updateSubtotal());
			order.add(orderItem);
		}
		order.setState("0");
		order.setTime(new Date());
		orderDao.save(order);
		return order;
	}

	public List<Order> findByClientId(Integer clientId) {
		return orderDao.findByClientId(clientId);
	}

	public Order findById(Integer id) {
		return orderDao.findById(id);
	}

	public void pay(Integer id) {
		Order order = orderDao.findById(id);
		order.setState("1");
		orderDao.update(order);
	}

	public List<Order> findAll() {
		return orderDao.findAll();
	}

	// 管理后台订单查询
	public List<Order> find(Order order, Double total2) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class, "o");
		if (order.getName() != null) {
			criteria.add(Restrictions.like("name", order.getName(), MatchMode.ANYWHERE));
		}
		if (order.getPhone() != null) {
			criteria.add(Restrictions.like("phone", order.getPhone(), MatchMode.ANYWHERE));
		}
		if (order.getAddress() != null) {
			criteria.add(Restrictions.like("address", order.getAddress(), MatchMode.ANYWHERE));
		}
		if (order.getTotal() != null) {
			criteria.add(Restrictions.ge("total", order.getTotal()));
		}
		if (total2 != null) {
			criteria.add(Restrictions.le("total", total2));
		}
		if (order.getState() != null) {
			criteria.add(Restrictions.eq("state", order.getState()));
		}
		return orderDao.findByCriteria(criteria);
	}

}
