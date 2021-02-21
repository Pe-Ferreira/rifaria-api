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
import com.rifaria.rifariaapi.repository.PrizeRepository;

@RestController
public class PrizeController {

	@Autowired
	private PrizeRepository repo;
	
	@PostMapping(value = "/prize")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Prize save(@RequestBody Prize prize) {
		return repo.save(prize);
	}
	
	@GetMapping(value = "/prize")
	public List<Prize> getAllPremios() throws Exception {
		return repo.findAll();
	}
	
	@GetMapping(value = "/prize/{id}")
	public Prize findByPremioId(@PathVariable Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrada"));
	}
	
	@DeleteMapping(value = "/prize/{id}")
	public ResponseEntity<?> deletePremio(@PathVariable Integer id) throws Exception {
		return repo.findById(id).map(prize -> {
			repo.delete(prize);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrado"));
	}
	
	@PutMapping(value = "/prize/{id}")
	public ResponseEntity<Prize> updatePremio(@PathVariable Integer id, @RequestBody Prize newPrize) throws Exception {
		return repo.findById(id).map(prize -> {
			prize.setTitle(newPrize.getTitle());
			prize.setValue(newPrize.getValue());
			repo.save(prize);
			return ResponseEntity.ok(prize);
		}).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrado"));
	}
}
