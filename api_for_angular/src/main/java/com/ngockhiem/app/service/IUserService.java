package com.ngockhiem.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.ngockhiem.app.dto.UserDTO;

public interface IUserService {
	ResponseEntity<UserDTO> save(UserDTO userDTO);

	ResponseEntity<UserDTO> update(UserDTO userDTO);

	void delete(long ids[]);

	List<UserDTO> findAll(Pageable pageable);

	int totalItem();
	ResponseEntity<UserDTO> findOne(long id);
}
