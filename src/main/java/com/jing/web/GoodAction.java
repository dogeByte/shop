package com.jing.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.jing.service.Category1Service;
import com.jing.service.Category2Service;
import com.jing.service.GoodService;
import com.jing.utils.UploadUtils;
import com.jing.vo.Category1;
import com.jing.vo.Category2;
import com.jing.vo.Good;
import com.jing.vo.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class GoodAction extends ActionSupport implements ModelDriven<Good> {

	private static final long serialVersionUID = 4817808111925929532L;
	private Good good = new Good();
	private GoodService goodService;
	private Category1Service category1Service;
	private Category2Service category2Service;

	private Integer category1Id;
	private Integer category2Id;

	private File upload;
	@SuppressWarnings("unused")
	private String uploadContentType;
	private String uploadFileName;

	private Page<Good> page;
	private Integer currentPage;
	private Integer limit;

	@Override
	public Good getModel() {
		return good;
	}

	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	public void setCategory1Service(Category1Service category1Service) {
		this.category1Service = category1Service;
	}

	public void setCategory2Service(Category2Service category2Service) {
		this.category2Service = category2Service;
	}

	public void setCategory1Id(Integer category1Id) {
		this.category1Id = category1Id;
	}

	public void setCategory2Id(Integer category2Id) {
		this.category2Id = category2Id;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Page<Good> getPage() {
		return page;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	
	private void pushCategory1s() {
		List<Category1> category1s = category1Service.findAll();
		ActionContext.getContext().getValueStack().push(category1s);
	}

	public String listByCategory1IdPage() {
		this.pushCategory1s();
		page = goodService.findByCategory1IdAndPage(category1Id, new Page<Good>(currentPage, 8));
		return "listByCategory1IdPageSuccess";
	}
	
	public String listByCategory2IdPage() {
		this.pushCategory1s();
		page = goodService.findByCategory2IdAndPage(category2Id, new Page<Good>(currentPage, 8));
		return "listByCategory2IdPageSuccess";
	}
	
	public String detail() {
		this.pushCategory1s();
		good = goodService.findById(good.getId());
		return "detailSuccess";
	}

}
