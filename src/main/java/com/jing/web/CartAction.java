package com.jing.web;

import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.jing.service.CartService;
import com.jing.vo.Cart;
import com.jing.vo.Client;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CartAction extends ActionSupport implements ModelDriven<Cart>, SessionAware {

	private static final long serialVersionUID = 4558034962582603351L;
	private Cart cart = new Cart();
	private Map<String, Object> session;
	private CartService cartService;
	private Integer goodId;
	private Integer basketId;
	private Integer count;

	@Override
	public Cart getModel() {
		return cart;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String show() {
		cart = cartService.findById(cart.getId());
		return "showSuccess";
	}

	public String add() {
		cartService.add(cart.getId(), goodId, count);
		this.sync();
		return SUCCESS;
	}


	public String update() throws IOException {
		cartService.update(basketId, count);
		Cart cart = this.sync();
		String subtotal = String.format("%.2f", cart.getSubtotal(basketId));
		String total = String.format("%.2f", cart.getTotal());
		ServletActionContext.getResponse().getWriter().print(subtotal + "::" + total);
		return NONE;
	}


}
