package com.ngockhiem.app.controller.output;

import java.util.ArrayList;
import java.util.List;

import com.ngockhiem.app.dto.RoleDTO;

public class RoleOutput {
	private int page;
	private int totalPage;
	private List<RoleDTO> listRole = new ArrayList<RoleDTO>();

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

	public List<RoleDTO> getListRole() {
		return listRole;
	}

	public void setListRole(List<RoleDTO> listRole) {
		this.listRole = listRole;
	}

}
