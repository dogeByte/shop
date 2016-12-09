package com.jing.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private Integer id;
	private String name;
	private String phone;
	private String address;
	private String state;
	private Date time;
	private Client client;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	private Double total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	public Double updateTotal() {
		this.total = 0d;
		if (this.orderItems != null && this.orderItems.size() != 0) {
			for (OrderItem orderItem : this.orderItems) {
				this.total += orderItem.updateSubtotal();
			}
		}
		return this.total;
	}

	public void add(OrderItem orderItem) {
		this.orderItems.add(orderItem);
		this.updateTotal();
	}

}
