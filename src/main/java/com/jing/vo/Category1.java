package com.jing.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Category1 {

	private Integer id;
	private String name;
	private Set<Category2> category2s = new HashSet<Category2>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JSON(serialize = false)
	public Set<Category2> getCategory2s() {
		return category2s;
	}

	public void setCategory2s(Set<Category2> category2s) {
		this.category2s = category2s;
	}

	@Override
	public String toString() {
		return "Category1 [id=" + id + ", name=" + name + ", category2s=" + category2s + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category1 other = (Category1) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
