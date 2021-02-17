package com.ngockhiem.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ngockhiem.app.dto.RoleDTO;

public interface IRoleService {
	ResponseEntity<RoleDTO> save(RoleDTO roleDTO);

	ResponseEntity<RoleDTO> update(RoleDTO roleDTO);

	void delete(long ids[]);

	List<RoleDTO> findAll(Pageable pageable);

	int totalItem();

}
