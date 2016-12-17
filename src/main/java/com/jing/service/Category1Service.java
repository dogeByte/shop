package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.Category1Dao;
import com.jing.vo.Category1;

@Transactional
public class Category1Service {
	
	private Category1Dao category1Dao;

	public void setCategory1Dao(Category1Dao category1Dao) {
		this.category1Dao = category1Dao;
	}

	public List<Category1> findAll() {
		return category1Dao.findAll();
	}

}
