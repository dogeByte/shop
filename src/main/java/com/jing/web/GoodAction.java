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

	public String addPage() {
		List<Category1> category1s = category1Service.findAll();
		ActionContext.getContext().getValueStack().push(category1s);
		return "addPageSuccess";
	}

	@InputConfig(resultName = "addFailure")
	public String add() {
		good.setCategory2(category2Service.findCategory2ById(category2Id));
		if (upload != null) {
			String hashPath = UploadUtils.getHashPath(uploadFileName);
			File fullPath = new File(ServletActionContext.getServletContext().getRealPath(hashPath));
			if (!fullPath.exists()) {
				fullPath.mkdirs();
			}
			String uuidName = UploadUtils.getUuidName(uploadFileName);
			try {
				FileUtils.copyFile(upload, new File(fullPath, uuidName));
			} catch (IOException e) {
				e.printStackTrace();
				return "addFailure";
			}
			good.setImage(new File(hashPath, uuidName).toString());
		}
		goodService.add(good);
		limit = 10;
		currentPage = this.goodService.getTotalPage(limit);
		page = new Page<Good>(currentPage ,limit);
		return "addSuccess";
	}

	public String showPage() {
		page = goodService.findByPage(new Page<Good>(currentPage, limit));
		return "showPageSuccess";
	}

	public String updatePage() {
		good = goodService.findById(good.getId());
		Set<Category2> category2s = good.getCategory2().getCategory1().getCategory2s();
		List<Category1> category1s = category1Service.findAll();
		ActionContext.getContext().getValueStack().push(category2s);
		ActionContext.getContext().getValueStack().push(category1s);
		page = new Page<Good>(currentPage, limit);
		return "updatePageSuccess";
	}

	@InputConfig(resultName = "updateFailure")
	public String update() {
		good.setCategory2(category2Service.findCategory2ById(category2Id));
		if (upload != null) {
			String hashPath = UploadUtils.getHashPath(uploadFileName);
			File fullPath = new File(ServletActionContext.getServletContext().getRealPath(hashPath));
			if (!fullPath.exists()) {
				fullPath.mkdirs();
			}
			String uuidName = UploadUtils.getUuidName(uploadFileName);
			try {
				FileUtils.copyFile(upload, new File(fullPath, uuidName));
			} catch (IOException e) {
				e.printStackTrace();
				return "updateFailure";
			}
			good.setImage(new File(hashPath, uuidName).toString());
		}
		goodService.update(good);
		page = new Page<Good>(currentPage, limit);
		return "updateSuccess";
	}

	public String delete() {
		goodService.delete(good);
		page = new Page<Good>(1, limit);
		return "deleteSuccess";
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
