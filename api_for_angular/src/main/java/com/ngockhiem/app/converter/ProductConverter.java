package com.ngockhiem.app.converter;

import org.springframework.stereotype.Component;

import com.ngockhiem.app.dto.ProductDTO;
import com.ngockhiem.app.entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setProductName(dto.getProductName());
		entity.setProductImage(dto.getProductImage());
		entity.setProductPrice(dto.getProductPrice());
		entity.setProductDiscountPrice(dto.getProductDiscountPrice());
		entity.setProductTotal(dto.getProductTotal());
		entity.setProductIntro(dto.getProductIntro());
		entity.setProductNotes(dto.getProductNotes());
		entity.setProductSize(dto.getProductSize());
		return entity;
	}
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setProductName(entity.getProductName());
		dto.setProductImage(entity.getProductImage());
		dto.setProductPrice(entity.getProductPrice());
		dto.setProductDiscountPrice(entity.getProductDiscountPrice());
		dto.setProductTotal(entity.getProductTotal());
		dto.setProductIntro(entity.getProductIntro());
		dto.setProductNotes(entity.getProductNotes());
		dto.setProductSize(entity.getProductSize());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setCategory(entity.getCategory());
		dto.setOrder(entity.getOrder());
		return dto;
	}
	
	public ProductEntity toEntity(ProductDTO dto, ProductEntity entity) {
		entity.setProductName(dto.getProductName());
		entity.setProductImage(dto.getProductImage());
		entity.setProductPrice(dto.getProductPrice());
		entity.setProductDiscountPrice(dto.getProductDiscountPrice());
		entity.setProductTotal(dto.getProductTotal());
		entity.setProductIntro(dto.getProductIntro());
		entity.setProductNotes(dto.getProductNotes());
		entity.setProductSize(dto.getProductSize());
		return entity;
	}
}
