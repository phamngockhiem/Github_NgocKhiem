package com.ngockhiem.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.converter.CategoryConverter;
import com.ngockhiem.app.dto.CategoryDTO;
import com.ngockhiem.app.entity.CategoryEntity;
import com.ngockhiem.app.repository.CategoryRepository;
import com.ngockhiem.app.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryConverter.toEntity(categoryDTO);
		categoryEntity = categoryRepository.save(categoryEntity);
		return ResponseEntity.ok(categoryConverter.toDTO(categoryEntity));
	}

	@Override
	public ResponseEntity<CategoryDTO> update(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		CategoryEntity oldCategoryEntity = categoryRepository.findById(categoryDTO.getId()).get();
		CategoryEntity categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategoryEntity);
		categoryEntity = categoryRepository.save(categoryEntity);
		return ResponseEntity.ok(categoryConverter.toDTO(categoryEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long item : ids) {
			categoryRepository.deleteById(item);
		}
	}

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entity = categoryRepository.findAll(pageable).getContent();
		for (CategoryEntity item : entity) {
			CategoryDTO categoryDTO = categoryConverter.toDTO(item);
			listCategoryDTO.add(categoryDTO);
		}
		return listCategoryDTO;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) categoryRepository.count();
	}

}
