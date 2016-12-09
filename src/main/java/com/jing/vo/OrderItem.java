package com.jing.vo;

public class OrderItem {

	private Integer id;
	private Integer count;
	private Order order;
	private Good good;
	private Double subtotal;

	public OrderItem() {
		super();
	}

	public OrderItem(Integer count, Order order, Good good, Double subtotal) {
		super();
		this.count = count;
		this.order = order;
		this.good = good;
		this.subtotal = subtotal;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		return "OrderItem [id=" + id + ", count=" + count + "]";
	}
	
	public Double updateSubtotal() {
		if (count == null || good == null || good.getPrice() == null) {
			return 0d;
		}
		this.subtotal = count * good.getPrice();
		return this.subtotal;
	}

}
