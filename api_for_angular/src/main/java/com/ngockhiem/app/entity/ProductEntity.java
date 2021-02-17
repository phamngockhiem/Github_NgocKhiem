package com.ngockhiem.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class ProductEntity extends Base {
	@Column(name = "product_name")
	@NotNull
	private String productName;
	@Column(name = "product_image")
	private String productImage;
	@Column(name = "product_price")
	private String productPrice;
	@Column(name = "product_discount_price")
	private String productDiscountPrice;
	@Column(name = "product_total")
	private String productTotal;
	@Column(name = "product_intro")
	private String productIntro;
	@Column(name = "product_notes")
	private String productNotes;
	@Column(name = "product_size")
	private String productSize;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	public ProductEntity() {

	}

	public ProductEntity(@NotNull String productName, String productImage, String productPrice,
			String productDiscountPrice, String productTotal, String productIntro, String productNotes,
			String productSize, CategoryEntity category, OrderEntity order) {
		super();
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDiscountPrice = productDiscountPrice;
		this.productTotal = productTotal;
		this.productIntro = productIntro;
		this.productNotes = productNotes;
		this.productSize = productSize;
		this.category = category;
		this.order = order;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDiscountPrice() {
		return productDiscountPrice;
	}

	public void setProductDiscountPrice(String productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}

	public String getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(String productTotal) {
		this.productTotal = productTotal;
	}

	public String getProductIntro() {
		return productIntro;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}

	public String getProductNotes() {
		return productNotes;
	}

	public void setProductNotes(String productNotes) {
		this.productNotes = productNotes;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
