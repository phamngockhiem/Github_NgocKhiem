package com.ngockhiem.app.controller.output;

import java.util.ArrayList;
import java.util.List;

import com.ngockhiem.app.dto.ProductDTO;

public class ProductOutput {
	private int page;
	private int totalPage;
	private List<ProductDTO> listProduct = new ArrayList<ProductDTO>();

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

	public List<ProductDTO> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<ProductDTO> listProduct) {
		this.listProduct = listProduct;
	}

}
