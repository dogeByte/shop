package com.jing.utils;

import java.util.Comparator;

import com.jing.vo.Order;

public class OrderComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		return o1.getId() - o2.getId();
	}

}
