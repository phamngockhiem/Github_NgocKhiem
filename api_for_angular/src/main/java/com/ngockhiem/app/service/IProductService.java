package com.ngockhiem.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ngockhiem.app.dto.ProductDTO;

public interface IProductService {
	ResponseEntity<ProductDTO> save(ProductDTO productDTO);

	ResponseEntity<ProductDTO> update(ProductDTO productDTO);

	void delete(long ids[]);

	List<ProductDTO> findAll(Pageable pageable);

	int totalItem();
}
