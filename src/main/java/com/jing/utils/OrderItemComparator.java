package com.jing.utils;

import java.util.Comparator;

import com.jing.vo.OrderItem;

public class OrderItemComparator implements Comparator<OrderItem> {

	@Override
	public int compare(OrderItem item1, OrderItem item2) {
		return item1.getId() - item2.getId();
	}

}
