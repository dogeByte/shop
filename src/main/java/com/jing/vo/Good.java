package com.jing.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Good {

	private Integer id;
	private String name;
	private Double price;
	private String image;
	private Integer isHot;
	private String description;
	private Timestamp time;
	private Category2 category2;
	private Set<Basket> baskets = new HashSet<Basket>();
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Category2 getCategory2() {
		return category2;
	}

	public void setCategory2(Category2 category2) {
		this.category2 = category2;
	}

	public Set<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(Set<Basket> baskets) {
		this.baskets = baskets;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", isHot=" + isHot
				+ ", description=" + description + ", date=" + time + ", category2=" + category2 + "]";
	}

}
