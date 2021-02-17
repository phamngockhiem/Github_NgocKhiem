package com.ngockhiem.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.converter.OrderConverter;
import com.ngockhiem.app.dto.OrderDTO;
import com.ngockhiem.app.entity.OrderEntity;
import com.ngockhiem.app.repository.OrderRepository;
import com.ngockhiem.app.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderConverter orderConverter;

	@Override
	public ResponseEntity<OrderDTO> save(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		OrderEntity orderEntity = orderConverter.toEntity(orderDTO);
		orderEntity = orderRepository.save(orderEntity);
		return ResponseEntity.ok(orderConverter.toDTO(orderEntity));
	}

	@Override
	public ResponseEntity<OrderDTO> update(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId()).get();
		OrderEntity orderEntity = orderConverter.toEntity(orderDTO, oldOrderEntity);
		orderEntity = orderRepository.save(orderEntity);
		return ResponseEntity.ok(orderConverter.toDTO(orderEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long item : ids) {
			orderRepository.deleteById(item);
		}
	}

	@Override
	public List<OrderDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<OrderDTO> listOrderDTO = new ArrayList<OrderDTO>();
		List<OrderEntity> entity = orderRepository.findAll(pageable).getContent();
		for (OrderEntity item : entity) {
			OrderDTO orderDTO = orderConverter.toDTO(item);
			listOrderDTO.add(orderDTO);
		}
		return listOrderDTO;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) orderRepository.count();
	}

}
