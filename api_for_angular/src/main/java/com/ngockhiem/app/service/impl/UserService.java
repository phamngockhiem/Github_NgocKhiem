package com.ngockhiem.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.converter.UserConverter;
import com.ngockhiem.app.dto.UserDTO;
import com.ngockhiem.app.entity.UserEntity;
import com.ngockhiem.app.repository.UserRepository;
import com.ngockhiem.app.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<UserDTO> save(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userConverter.toEntity(userDTO);
		userEntity = userRepository.save(userEntity);
		return ResponseEntity.ok(userConverter.toDTO(userEntity));
	}

	@Override
	public ResponseEntity<UserDTO> update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserEntity oldUserENtity = userRepository.findById(userDTO.getId()).get();
		UserEntity userEntity = userConverter.toEntity(userDTO, oldUserENtity);
		userEntity = userRepository.save(userEntity);
		return ResponseEntity.ok(userConverter.toDTO(userEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long item:ids) {
			userRepository.deleteById(item);
		}
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<UserEntity> entity = userRepository.findAll(pageable).getContent();
		for (UserEntity item : entity) {
			UserDTO userDTO = userConverter.toDTO(item);
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) userRepository.count();
	}

	@Override
	public ResponseEntity<UserDTO> findOne(long id) {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		UserEntity entity = userConverter.toEntity(dto);
		entity = userRepository.getOne(id);
		return ResponseEntity.ok(userConverter.toDTO(entity));
	}
}
