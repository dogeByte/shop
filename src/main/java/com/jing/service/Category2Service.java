package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.Category2Dao;
import com.jing.vo.Category2;

@Transactional
public class Category2Service {
	
	private Category2Dao category2Dao;

	public void setCategory2Dao(Category2Dao category2Dao) {
		this.category2Dao = category2Dao;
	}

	public List<Category2> findCategory2sByCategory1Id(Integer category1Id) {
		return category2Dao.findCategory2sByCategory1Id(category1Id);
	}

	public Category2 findCategory2ById(Integer category2Id) {
		return category2Dao.findCategory2ById(category2Id);
	}

}
