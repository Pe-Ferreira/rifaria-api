package com.rifaria.rifariaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifaria.rifariaapi.model.User;
import com.rifaria.rifariaapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User salvar(@RequestBody User user) {
		return service.save(user);
	}
	
	@GetMapping(value = "/user")
	public List<User> getAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping(value = "/user/{id}")
	public User get(@PathVariable Integer id) throws Exception {
		return service.findById(id);
	}
	
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		return service.delete(id);
	}
	
	@PutMapping(value = "/user/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User newUser) throws Exception {
		return service.update(id, newUser);
	}
}
