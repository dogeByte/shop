package com.jing.vo;

import java.util.List;

public class Page<T> {

	// 当前页数
	private Integer currentPage;
	// 单页记录数
	private Integer limit;
	// 总页数
	private Integer totalPage;
	// 总记录数
	private Integer count;
	// 当前页面记录集合
	private List<T> beans;

	public Page() {
		super();
	}

	public Page(Integer currentPage, Integer limit) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getBeans() {
		return beans;
	}

	public void setBeans(List<T> beans) {
		this.beans = beans;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", limit=" + limit + ", totalPage=" + totalPage + ", count=" + count
				+ ", beans=" + beans + "]";
	}
}
