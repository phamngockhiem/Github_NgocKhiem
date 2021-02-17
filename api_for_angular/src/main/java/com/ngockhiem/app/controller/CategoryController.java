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

import com.ngockhiem.app.controller.output.CategoryOutput;
import com.ngockhiem.app.dto.CategoryDTO;
import com.ngockhiem.app.service.ICategoryService;

@RestController
@CrossOrigin
@RequestMapping("/app")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping(value = "/category")
	public CategoryOutput showCategory(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		CategoryOutput result = new CategoryOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListCategory(categoryService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) categoryService.totalItem() / limit));
		return result;
	}
	@PostMapping(value = "/category")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO model) {
		return categoryService.save(model);
	}
	
	@PutMapping(value = "/category/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO model, @PathVariable long id) {
		model.setId(id);
		return categoryService.update(model);
	}
	
	@DeleteMapping(value = "/category")
	public void deleteCategory(@RequestBody long ids[]) {
		categoryService.delete(ids);
	}
}
