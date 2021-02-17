package com.ngockhiem.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity extends Base {
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products = new ArrayList<>();

	public CategoryEntity() {

	}

	public CategoryEntity(String code, String name, List<ProductEntity> products) {
		super();
		this.code = code;
		this.name = name;
		this.products = products;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}
