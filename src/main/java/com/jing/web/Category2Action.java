package com.jing.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jing.service.Category2Service;
import com.jing.vo.Category2;
import com.opensymphony.xwork2.ActionSupport;

public class Category2Action extends ActionSupport {

	private static final long serialVersionUID = 5244020809438800930L;
	private Category2Service category2Service;
	private List<Category2> category2s = new ArrayList<Category2>();
	private Integer category1Id;

	public void setCategory2Service(Category2Service category2Service) {
		this.category2Service = category2Service;
	}

	public List<Category2> getCategory2s() {
		return category2s;
	}

	public void setCategory1Id(Integer category1Id) {
		this.category1Id = category1Id;
	}

	public String findCategory2sByCategory1Id() throws IOException {
		category2s = category2Service.findCategory2sByCategory1Id(category1Id);
		return "findCategory2sByCategory1IdSuccess";
	}

}
