package com.ngockhiem.app.controller.output;

import java.util.ArrayList;
import java.util.List;

import com.ngockhiem.app.dto.OrderDTO;

public class OrderOutput {
	private int page;
	private int totalPage;
	private List<OrderDTO> listOrder = new ArrayList<OrderDTO>();

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

	public List<OrderDTO> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<OrderDTO> listOrder) {
		this.listOrder = listOrder;
	}

	

}
