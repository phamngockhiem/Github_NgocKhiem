package com.ngockhiem.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngockhiem.app.controller.output.OrderOutput;
import com.ngockhiem.app.dto.OrderDTO;
import com.ngockhiem.app.service.IOrderService;

@CrossOrigin
@RestController
@RequestMapping("/app")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@GetMapping(value = "/order")
	public OrderOutput showOrder(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		OrderOutput result = new OrderOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListOrder(orderService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) orderService.totalItem() / limit));
		return result;
	}
	@PostMapping(value = "/order")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO model) {
		return orderService.save(model);
	}
	
	@PutMapping(value = "/order/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO model, @PathVariable long id) {
		model.setId(id);
		return orderService.update(model);
	}
	
	@DeleteMapping(value = "/order")
	public void deleteOrder(@RequestBody long ids[]) {
		orderService.delete(ids);
	}
}
