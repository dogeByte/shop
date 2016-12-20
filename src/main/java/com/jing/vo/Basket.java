package com.jing.vo;

public class Basket {

	private Integer id;
	private Integer count;
	private Cart cart;
	private Good good;
	private Double subtotal;

	public Basket() {
		super();
	}

	public Basket(Integer count, Cart cart, Good good) {
		super();
		this.count = count;
		this.cart = cart;
		this.good = good;
		this.updateSubtotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", count=" + count + ", good=" + good.getId() + "]";
	}

	public Double updateSubtotal() {
		if (count == null || good == null || good.getPrice() == null) {
			return 0d;
		}
		this.subtotal = count * good.getPrice();
		return this.subtotal;
	}

}
