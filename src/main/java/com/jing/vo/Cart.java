package com.jing.vo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cart {

	private Integer id;
	private Client client;
	private Set<Basket> baskets = new HashSet<Basket>();
	private Double total = 0d;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(Set<Basket> baskets) {
		this.baskets = baskets;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", baskets=" + baskets + "]";
	}

	public Double updateTotal() {
		this.total = 0d;
		if (this.baskets != null && this.baskets.size() != 0) {
			for (Basket basket : this.baskets) {
				this.total += basket.updateSubtotal();
			}
		}
		return this.total;
	}

	public void add(Basket basket) {
		this.baskets.add(basket);
		this.updateTotal();
	}

	public void remove(Integer basketId) {
		for (Iterator<Basket> it = this.baskets.iterator();it.hasNext();){
			Basket basket = it.next();
			if (basketId.equals(basket.getId())) {
				it.remove();
				break;
			}
		}
		this.updateTotal();
	}
	
	public void clear() {
		this.setBaskets(new HashSet<Basket>());
		this.setTotal(0d);
	}
	
	public void update(Integer basketId, Integer count) {
		for (Basket basket : this.baskets) {
			if (basketId.equals(basket.getId())) {
				basket.setCount(count);
				break;
			}
		}
		this.updateTotal();
	}

	// 计算指定购物项的小计价格
	public Double getSubtotal(Integer basketId) {
		for (Basket basket : this.baskets) {
			if (basketId.equals(basket.getId())) {
				return basket.getSubtotal();
			}
		}
		return 0d;
	}

}
