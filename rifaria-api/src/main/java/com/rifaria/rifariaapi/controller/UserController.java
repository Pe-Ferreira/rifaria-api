package com.rifaria.rifariaapi.controller;

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
import com.rifaria.rifariaapi.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@PostMapping(value = "/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User salvar(@RequestBody User user) {
		return repo.save(user);
	}
	
	@GetMapping(value = "/user/{id}")
	public User findByUserId(@PathVariable Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("User [id = " + id + "] não foi encontrado"));
	}
	
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws Exception {
		return repo.findById(id).map(user -> {
			repo.delete(user);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("User [id = " + id + "] não foi encontrado"));
	}
	
	@PutMapping(value = "/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User newUser) throws Exception {
		return repo.findById(id).map(user -> {
			user.setNome(newUser.getNome());
			user.setEmail(newUser.getEmail());
			user.setSenha(newUser.getSenha());
			repo.save(user);
			return ResponseEntity.ok(user);
		}).orElseThrow(() -> new Exception("User [id = " + id + "] não foi encontrado"));
	}
}
