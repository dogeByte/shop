package com.jing.utils;

import java.util.Comparator;

import com.jing.vo.Basket;

public class BasketComparator implements Comparator<Basket> {

	@Override
	public int compare(Basket b1, Basket b2) {
		return b1.getId() - b2.getId();
	}

}
