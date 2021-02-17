package com.ngockhiem.app.controller.output;

import java.util.ArrayList;
import java.util.List;

import com.ngockhiem.app.dto.UserDTO;

public class UserOutput {
	private int page;
	private int totalPage;
	private List<UserDTO> listUser = new ArrayList<UserDTO>();

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

	public List<UserDTO> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserDTO> listUser) {
		this.listUser = listUser;
	}

}
