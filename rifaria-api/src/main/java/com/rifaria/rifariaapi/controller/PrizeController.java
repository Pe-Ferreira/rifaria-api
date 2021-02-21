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

import com.rifaria.rifariaapi.model.Prize;
import com.rifaria.rifariaapi.service.PrizeService;

@RestController
public class PrizeController {

	@Autowired
	private PrizeService service;
	
	@PostMapping(value = "/prize")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Prize save(@RequestBody Prize prize) {
		return service.save(prize);
	}
	
	@GetMapping(value = "/prize")
	public List<Prize> getAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping(value = "/prize/{id}")
	public Prize get(@PathVariable Integer id) throws Exception {
		return service.findById(id);
	}
	
	@DeleteMapping(value = "/prize/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		return service.delete(id);
	}
	
	@PutMapping(value = "/prize/{id}")
	public ResponseEntity<Prize> update(@PathVariable Integer id, @RequestBody Prize newPrize) throws Exception {
		return service.update(id, newPrize);
	}
}
