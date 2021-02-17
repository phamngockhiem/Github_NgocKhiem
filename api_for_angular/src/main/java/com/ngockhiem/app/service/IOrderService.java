package com.ngockhiem.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ngockhiem.app.dto.OrderDTO;

public interface IOrderService {
	ResponseEntity<OrderDTO> save(OrderDTO orderDTO);

	ResponseEntity<OrderDTO> update(OrderDTO orderDTO);

	void delete(long ids[]);

	List<OrderDTO> findAll(Pageable pageable);

	int totalItem();
}
