package com.ngockhiem.app.converter;

import org.springframework.stereotype.Component;

import com.ngockhiem.app.dto.CategoryDTO;
import com.ngockhiem.app.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
}
