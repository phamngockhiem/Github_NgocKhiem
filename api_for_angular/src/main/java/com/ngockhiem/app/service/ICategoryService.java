package com.ngockhiem.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ngockhiem.app.dto.CategoryDTO;

public interface ICategoryService {
	ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO);

	ResponseEntity<CategoryDTO> update(CategoryDTO categoryDTO);

	void delete(long ids[]);

	List<CategoryDTO> findAll(Pageable pageable);

	int totalItem();
}
