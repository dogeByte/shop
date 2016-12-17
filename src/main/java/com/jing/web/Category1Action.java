package com.jing.web;

import java.util.ArrayList;
import java.util.List;

import com.jing.service.Category1Service;
import com.jing.vo.Category1;
import com.opensymphony.xwork2.ActionSupport;

public class Category1Action extends ActionSupport {

	private static final long serialVersionUID = 8764382816120774259L;
	private Category1Service category1Service;
	private List<Category1> category1s = new ArrayList<Category1>();

	public void setCategory1Service(Category1Service category1Service) {
		this.category1Service = category1Service;
	}
	
	public List<Category1> getCategory1s() {
		return category1s;
	}

	// ajax
	public String findAll() {
		category1s = category1Service.findAll();
		return "findAllSuccess";
	}
	
}
