package com.jing.service;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.CartDao;
import com.jing.dao.GoodDao;
import com.jing.vo.Basket;
import com.jing.vo.Cart;

@Transactional
public class CartService {
	
	private CartDao cartDao;
	private GoodDao goodDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	
	public Cart findById(Integer id) {
		return cartDao.findById(id);
	}

	public void add(Integer id, Integer goodId, Integer count) {
		Basket basket = cartDao.findBasketByIdAndGoodId(id, goodId);
		Cart cart = cartDao.findById(id);
		if (basket == null || basket.getId() == null) {
			basket = new Basket(count, cart, goodDao.findById(goodId));
		} else {
			basket.setCount(basket.getCount() + count);
			basket.updateSubtotal();
		}
		cart.add(basket);
		cartDao.update(cart);
	}

	// 更新一条指定的购物项
	public void update(Integer basketId, Integer count) {
		Cart cart = cartDao.findByBasketId(basketId);
		cart.update(basketId, count);
		cartDao.update(cart);
	}

}
