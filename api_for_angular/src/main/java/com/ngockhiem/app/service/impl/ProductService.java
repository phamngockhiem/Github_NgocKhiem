package com.ngockhiem.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.converter.ProductConverter;
import com.ngockhiem.app.dto.ProductDTO;
import com.ngockhiem.app.entity.ProductEntity;
import com.ngockhiem.app.repository.ProductRepository;
import com.ngockhiem.app.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public ResponseEntity<ProductDTO> save(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		ProductEntity productEntity = productConverter.toEntity(productDTO);
		productEntity = productRepository.save(productEntity);
		return ResponseEntity.ok(productConverter.toDTO(productEntity));
	}

	@Override
	public ResponseEntity<ProductDTO> update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		ProductEntity oldProductEntity = productRepository.findById(productDTO.getId()).get();
		ProductEntity productEntity = productConverter.toEntity(productDTO, oldProductEntity);
		productEntity = productRepository.save(productEntity);
		return ResponseEntity.ok(productConverter.toDTO(productEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long item : ids) {
			productRepository.deleteById(item);
		}
	}

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> entity = productRepository.findAll(pageable).getContent();
		for (ProductEntity item : entity) {
			ProductDTO productDTO = productConverter.toDTO(item);
			listProductDTO.add(productDTO);
		}
		return listProductDTO;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) productRepository.count();
	}

}
