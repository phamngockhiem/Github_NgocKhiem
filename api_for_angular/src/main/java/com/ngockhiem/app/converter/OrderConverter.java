package com.ngockhiem.app.converter;

import org.springframework.stereotype.Component;

import com.ngockhiem.app.dto.OrderDTO;
import com.ngockhiem.app.entity.OrderEntity;

@Component
public class OrderConverter {
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderCode(dto.getOrderCode());
		entity.setQuantity(dto.getQuantity());
		entity.setOrderNotes(dto.getOrderNotes());
		entity.setStatus(dto.isStatus());
		entity.setTotalPrice(dto.getTotalPrice());
		entity.setUserCode(dto.getUserCode());
		return entity;
	}
	
	public OrderDTO toDTO(OrderEntity entity) {
		OrderDTO dto = new OrderDTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setOrderCode(entity.getOrderCode());
		dto.setQuantity(entity.getQuantity());
		dto.setOrderNotes(entity.getOrderNotes());
		dto.setStatus(entity.isStatus());
		dto.setTotalPrice(entity.getTotalPrice());
		dto.setUserCode(entity.getUserCode());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}
	
	public OrderEntity toEntity(OrderDTO dto, OrderEntity entity) {
		entity.setOrderCode(dto.getOrderCode());
		entity.setQuantity(dto.getQuantity());
		entity.setOrderNotes(dto.getOrderNotes());
		entity.setStatus(dto.isStatus());
		entity.setTotalPrice(dto.getTotalPrice());
		entity.setUserCode(dto.getUserCode());
		return entity;
	}
}
