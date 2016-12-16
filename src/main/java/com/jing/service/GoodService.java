package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.GoodDao;
import com.jing.vo.Good;
import com.jing.vo.Page;

@Transactional
public class GoodService {

	private GoodDao goodDao;

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public void add(Good good) {
		goodDao.add(good);
	}

	public void update(Good good) {
		goodDao.update(good);
	}

	public Page<Good> findByPage(Page<Good> page) {
		page.setBeans(goodDao.findByPage(page));
		Integer count = goodDao.findCount();
		page.setCount(count);
		Integer totalPage = count / page.getLimit();
		page.setTotalPage((count % page.getLimit() == 0) ? totalPage : totalPage + 1);
		return page;
	}

	public Good findById(Integer id) {
		return goodDao.findById(id);
	}

	public void delete(Good good) {
		goodDao.delele(good);
	}

	public Integer getTotalPage(Integer limit) {
		Integer count = goodDao.findCount();
		Integer totalPage = count / limit;
		return (count % limit == 0) ? totalPage : totalPage + 1;
	}

	public List<Good> findHot() {
		return goodDao.findHot();
	}

	public List<Good> findNew() {
		return goodDao.findNew();
	}

	public Page<Good> findByCategory1IdAndPage(Integer category1Id, Page<Good> page) {
		List<Good> goods = goodDao.findByCategory1IdAndPage(category1Id, page);
		page.setBeans(goods);
		Integer count = goodDao.findCountByCategory1Id(category1Id);
		page.setCount(count);
		Integer totalPage = count / page.getLimit();
		page.setTotalPage((count % page.getLimit() == 0) ? totalPage : totalPage + 1);
		return page;
	}

	public Page<Good> findByCategory2IdAndPage(Integer category2Id, Page<Good> page) {
		List<Good> goods = goodDao.findByCategory2IdAndPage(category2Id, page);
		page.setBeans(goods);
		Integer count = goodDao.findCountByCategory2Id(category2Id);
		page.setCount(count);
		Integer totalPage = count / page.getLimit();
		page.setTotalPage((count % page.getLimit() == 0) ? totalPage : totalPage + 1);
		return page;
	}

}
