package com.ngockhiem.app.converter;

import org.springframework.stereotype.Component;

import com.ngockhiem.app.dto.RoleDTO;
import com.ngockhiem.app.entity.RoleEntity;

@Component
public class RoleConverter {
	public RoleEntity toEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}

	public RoleDTO toDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
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

	public RoleEntity toEntity(RoleDTO dto, RoleEntity entity) {
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}

}
