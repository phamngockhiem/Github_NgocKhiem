package com.ngockhiem.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ngockhiem.app.converter.RoleConverter;
import com.ngockhiem.app.dto.RoleDTO;
import com.ngockhiem.app.entity.RoleEntity;
import com.ngockhiem.app.repository.RoleRepository;
import com.ngockhiem.app.service.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired 
	private RoleConverter roleConverter;
	
	@Override
	public ResponseEntity<RoleDTO> save(RoleDTO RoleDTO) {
		// TODO Auto-generated method stub
		RoleEntity RoleEntity = roleConverter.toEntity(RoleDTO);
		RoleEntity = roleRepository.save(RoleEntity);
		return ResponseEntity.ok(roleConverter.toDTO(RoleEntity));
	}

	@Override
	public ResponseEntity<RoleDTO> update(RoleDTO RoleDTO) {
		// TODO Auto-generated method stub
		RoleEntity oldRoleEntity = roleRepository.findById(RoleDTO.getId()).get();
		RoleEntity RoleEntity = roleConverter.toEntity(RoleDTO, oldRoleEntity);
		RoleEntity = roleRepository.save(RoleEntity);
		return ResponseEntity.ok(roleConverter.toDTO(RoleEntity));
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long item:ids) {
			roleRepository.deleteById(item);
		}
	}

	@Override
	public List<RoleDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<RoleDTO> listRoleDTO = new ArrayList<RoleDTO>();
		List<RoleEntity> entity = roleRepository.findAll(pageable).getContent();
		for (RoleEntity item : entity) {
			RoleDTO RoleDTO = roleConverter.toDTO(item);
			listRoleDTO.add(RoleDTO);
		}
		return listRoleDTO;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) roleRepository.count();
	}

}
