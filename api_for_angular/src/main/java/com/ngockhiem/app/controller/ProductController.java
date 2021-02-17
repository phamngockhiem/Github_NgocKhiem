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

import com.ngockhiem.app.controller.output.ProductOutput;
import com.ngockhiem.app.dto.ProductDTO;
import com.ngockhiem.app.service.IProductService;

@RestController
@CrossOrigin
@RequestMapping("/app")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping(value = "/product")
	public ProductOutput showProduct(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		ProductOutput result = new ProductOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListProduct(productService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) productService.totalItem() / limit));
		return result;
	}
	@PostMapping(value = "/product")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO model) {
		return productService.save(model);
	}
	
	@PutMapping(value = "/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO model, @PathVariable long id) {
		model.setId(id);
		return productService.update(model);
	}
	
	@DeleteMapping(value = "/product")
	public void deleteProduct(@RequestBody long ids[]) {
		productService.delete(ids);
	}
}
