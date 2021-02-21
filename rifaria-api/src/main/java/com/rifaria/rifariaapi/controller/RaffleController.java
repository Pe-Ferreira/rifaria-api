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

import com.rifaria.rifariaapi.model.Raffle;
import com.rifaria.rifariaapi.repository.RaffleRepository;
import com.rifaria.rifariaapi.service.RaffleService;

import DTO.RaffleDTO;

@RestController
public class RaffleController {

	@Autowired
	private RaffleRepository repo;
	
	@Autowired
	private RaffleService service;
	
	@PostMapping(value = "/raffle")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Raffle salvar(@RequestBody RaffleDTO raffleDTO) {
		return service.saveRaffle(raffleDTO);
	}
	
	@GetMapping(value = "/raffle")
	public List<Raffle> getAllRaffles() throws Exception {
		return repo.findAll();
	}
	
	@GetMapping(value = "/raffle/{id}")
	public Raffle findByRaffleId(@PathVariable Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Raffle [id = " + id + "] não foi encontrada"));
	}
	
	@DeleteMapping(value = "/raffle/{id}")
	public ResponseEntity<?> deleteRaffle(@PathVariable Integer id) throws Exception {
		return repo.findById(id).map(raffle -> {
			repo.delete(raffle);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Raffle [id = " + id + "] não foi encontrado"));
	}
	
	@PutMapping(value = "/raffle/{id}")
	public ResponseEntity<Raffle> updateRaffle(@PathVariable Integer id, @RequestBody Raffle newRaffle) throws Exception {
		return repo.findById(id).map(raffle -> {
			raffle.setNumber(newRaffle.getNumber());
			repo.save(raffle);
			return ResponseEntity.ok(raffle);
		}).orElseThrow(() -> new Exception("Raffle [id = " + id + "] não foi encontrado"));
	}
}
