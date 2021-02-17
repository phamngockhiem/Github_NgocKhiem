package com.ngockhiem.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class OrderEntity extends Base {
	@Column(name = "orderCode")
	private String orderCode;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "notes")
	private String orderNotes;

	@Column(name = "status")
	private boolean status;

	@Column(name = "totalPrice")
	private long totalPrice;

	@ManyToOne
	@JoinColumn(name = "order_user_Code")
	private UserEntity userCode;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<ProductEntity> order_products = new ArrayList<>();

	public OrderEntity() {

	}

	public OrderEntity(String orderCode, int quantity,  String orderNotes, boolean status,
			long totalPrice, UserEntity userCode, List<ProductEntity> order_products) {
		super();
		this.orderCode = orderCode;
		this.quantity = quantity;
		this.orderNotes = orderNotes;
		this.status = status;
		this.totalPrice = totalPrice;
		this.userCode = userCode;
		this.order_products = order_products;
	}

	public List<ProductEntity> getOrder_products() {
		return order_products;
	}

	public void setOrder_products(List<ProductEntity> order_products) {
		this.order_products = order_products;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public UserEntity getUserCode() {
		return userCode;
	}

	public void setUserCode(UserEntity userCode) {
		this.userCode = userCode;
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
