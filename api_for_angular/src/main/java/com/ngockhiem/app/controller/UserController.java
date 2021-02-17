package com.ngockhiem.app.controller;

import javax.validation.Valid;

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

import com.ngockhiem.app.controller.output.UserOutput;
import com.ngockhiem.app.dto.UserDTO;
import com.ngockhiem.app.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/app")
public class UserController {
	
	@GetMapping("/app")
	public String home() {
		return "This is home page";
	}

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/user")
	ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO model) {
		return userService.save(model);
	}

	@PutMapping(value = "/user/{id}")
	ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody UserDTO model) {
		model.setId(id);
		return userService.update(model);
	}

	@DeleteMapping(value = "/user")
	public void deleteUser(@RequestBody long[] ids) {
		userService.delete(ids);
	}

	@GetMapping(value = "/user")
	public UserOutput showUser(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		UserOutput result = new UserOutput();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListUser(userService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) userService.totalItem() / limit));
		return result;
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<UserDTO> getOne(@PathVariable("id") long id) {
		return userService.findOne(id);
	}
}
