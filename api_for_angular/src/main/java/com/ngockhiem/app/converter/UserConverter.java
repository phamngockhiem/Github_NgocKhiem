package com.ngockhiem.app.converter;

import org.springframework.stereotype.Component;

import com.ngockhiem.app.dto.UserDTO;
import com.ngockhiem.app.entity.UserEntity;

@Component
public class  UserConverter {
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setUserFullname(dto.getUserFullname());
		entity.setUserDateOfBirth(dto.getUserDateOfBirth());
		entity.setUserPhone(dto.getUserPhone());
		entity.setUserEmail(dto.getUserEmail());
		entity.setUserPosition(dto.getUserPosition());
		entity.setUserPermission(dto.getUserPermission());
		entity.setUserNotes(dto.getUserNotes());
		entity.setUserLastLogined(dto.getUserLastLogined());
		return entity;
	}

	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setUserFullname(entity.getUserFullname());
		dto.setUserDateOfBirth(entity.getUserDateOfBirth());
		dto.setUserPhone(entity.getUserPhone());
		dto.setUserEmail(entity.getUserEmail());
		dto.setUserPosition(entity.getUserPosition());
		dto.setUserPermission(entity.getUserPermission());
		dto.setUserNotes(entity.getUserNotes());
		dto.setUserLastLogined(entity.getUserLastLogined());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public UserEntity toEntity(UserDTO dto, UserEntity entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setUserFullname(dto.getUserFullname());
		entity.setUserDateOfBirth(dto.getUserDateOfBirth());
		entity.setUserPhone(dto.getUserPhone());
		entity.setUserEmail(dto.getUserEmail());
		entity.setUserPosition(dto.getUserPosition());
		entity.setUserPermission(dto.getUserPermission());
		entity.setUserNotes(dto.getUserNotes());
		entity.setUserLastLogined(dto.getUserLastLogined());
		return entity;
	}

}
