package com.ngockhiem.app.dto;

import com.ngockhiem.app.entity.UserEntity;

public class OrderDTO extends AbstractDTO<OrderDTO> {
	private String orderCode;

	private int quantity;

	private String orderNotes;

	private boolean status;

	private long totalPrice;

	private UserEntity userCode;

	public UserEntity getUserCode() {
		return userCode;
	}

	public void setUserCode(UserEntity userCode) {
		this.userCode = userCode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

}
