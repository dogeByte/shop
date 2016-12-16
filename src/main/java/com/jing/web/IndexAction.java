package com.jing.web;

import java.util.List;

import com.jing.service.GoodService;
import com.jing.vo.Good;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 6261354719047619823L;
	private GoodService goodService;
	private List<Good> hotGoods;
	private List<Good> newGoods;

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public List<Good> getHotGoods() {
		return hotGoods;
	}

	public List<Good> getNewGoods() {
		return newGoods;
	}

	@Override
	public String execute() throws Exception {
		hotGoods = this.findHot();
		newGoods = this.findNew();
		ActionContext.getContext().getValueStack().push(newGoods);
		ActionContext.getContext().getValueStack().push(hotGoods);
		return SUCCESS;
	}

	private List<Good> findHot() {
		return goodService.findHot();
	}

	private List<Good> findNew() {
		return goodService.findNew();
	}

}
