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

import com.rifaria.rifariaapi.model.Rifa;
import com.rifaria.rifariaapi.repository.RifaRepository;
import com.rifaria.rifariaapi.service.RifaService;

@RestController
public class RifaController {

	@Autowired
	private RifaRepository repo;
	
	@Autowired
	private RifaService service;
	
	@PostMapping(value = "/rifa")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Rifa salvar(@RequestBody Rifa rifa) {
		return service.salvarRifa(rifa);
	}
	
	@GetMapping(value = "/rifa")
	public List<Rifa> getAllRifas() throws Exception {
		return repo.findAll();
	}
	
	@GetMapping(value = "/rifa/{id}")
	public Rifa findByRifaId(@PathVariable Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Rifa [id = " + id + "] não foi encontrada"));
	}
	
	@DeleteMapping(value = "/rifa/{id}")
	public ResponseEntity<?> deleteRifa(@PathVariable Integer id) throws Exception {
		return repo.findById(id).map(rifa -> {
			repo.delete(rifa);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Rifa [id = " + id + "] não foi encontrado"));
	}
	
	@PutMapping(value = "/rifa/{id}")
	public ResponseEntity<Rifa> updateRifa(@PathVariable Integer id, @RequestBody Rifa newRifa) throws Exception {
		return repo.findById(id).map(rifa -> {
			rifa.setNumero(newRifa.getNumero());
			repo.save(rifa);
			return ResponseEntity.ok(rifa);
		}).orElseThrow(() -> new Exception("Rifa [id = " + id + "] não foi encontrado"));
	}
}
