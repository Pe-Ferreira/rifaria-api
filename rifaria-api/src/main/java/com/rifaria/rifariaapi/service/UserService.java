package com.rifaria.rifariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.User;
import com.rifaria.rifariaapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User save(User user) {
		return repo.save(user);
	}

	public Optional<User> findById(int id) {
		return repo.findById(id);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("User [id = " + id + "] not found"));
	}

	public ResponseEntity<?> delete(Integer id) throws Exception {
		return repo.findById(id).map(user -> {
			repo.delete(user);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("User [id = " + id + "] not found"));
	}

	public ResponseEntity<User> update(Integer id, User newUser) throws Exception {
		return repo.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			user.setPassword(newUser.getPassword());
			repo.save(user);
			return ResponseEntity.ok(user);
		}).orElseThrow(() -> new Exception("User [id = " + id + "] not found"));
	}
}
