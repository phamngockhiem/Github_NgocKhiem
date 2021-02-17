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

import com.ngockhiem.app.controller.output.RoleOutput;
import com.ngockhiem.app.dto.RoleDTO;
import com.ngockhiem.app.service.IRoleService;


@CrossOrigin
@RestController
@RequestMapping("/app")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	@GetMapping(value = "/role")
	public RoleOutput showRole(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		RoleOutput result = new RoleOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListRole(roleService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) roleService.totalItem() / limit));
		return result;
	}
	@PostMapping(value = "/role")
	public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO model) {
		return roleService.save(model);
	}
	
	@PutMapping(value = "/role/{id}")
	public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO model, @PathVariable long id) {
		model.setId(id);
		return roleService.update(model);
	}
	
	@DeleteMapping(value = "/role")
	public void deleteRole(@RequestBody long ids[]) {
		roleService.delete(ids);
	}
}
