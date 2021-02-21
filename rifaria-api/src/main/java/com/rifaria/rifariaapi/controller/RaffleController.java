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

import com.rifaria.rifariaapi.DTO.RaffleDTO;
import com.rifaria.rifariaapi.model.Raffle;
import com.rifaria.rifariaapi.service.RaffleService;

@RestController
public class RaffleController {
	
	@Autowired
	private RaffleService service;
	
	@PostMapping(value = "/raffle")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Raffle save(@RequestBody RaffleDTO raffleDTO) {
		return service.saveRaffle(raffleDTO);
	}
	
	@GetMapping(value = "/raffle")
	public List<Raffle> getAll() throws Exception {
		return service.findAll();
	}
	
	@GetMapping(value = "/raffle/{id}")
	public Raffle get(@PathVariable Integer id) throws Exception {
		return service.findById(id);
	}
	
	@DeleteMapping(value = "/raffle/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws Exception {
		return service.delete(id);
	}
	
	@PutMapping(value = "/raffle/{id}")
	public ResponseEntity<Raffle> updateRaffle(@PathVariable Integer id, @RequestBody Raffle newRaffle) throws Exception {
		return service.update(id, newRaffle);
	}
}
