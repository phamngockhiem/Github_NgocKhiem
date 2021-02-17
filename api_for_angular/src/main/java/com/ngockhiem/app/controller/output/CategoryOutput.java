package com.ngockhiem.app.controller.output;

import java.util.ArrayList;
import java.util.List;

import com.ngockhiem.app.dto.CategoryDTO;

public class CategoryOutput {
	private int page;
	private int totalPage;
	private List<CategoryDTO> listCategory = new ArrayList<CategoryDTO>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<CategoryDTO> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<CategoryDTO> listCategory) {
		this.listCategory = listCategory;
	}

}
