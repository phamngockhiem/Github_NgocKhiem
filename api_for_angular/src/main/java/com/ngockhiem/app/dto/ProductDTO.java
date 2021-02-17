package com.ngockhiem.app.dto;

import com.ngockhiem.app.entity.CategoryEntity;
import com.ngockhiem.app.entity.OrderEntity;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	private String productName;
	private String productImage;
	private String productPrice;
	private String productDiscountPrice;
	private String productTotal;
	private String productIntro;
	private String productNotes;
	private String productSize;
	private CategoryEntity category;
	private OrderEntity order;

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity categoryEntity) {
		this.category = categoryEntity;
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

}
