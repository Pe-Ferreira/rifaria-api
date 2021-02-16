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

import com.rifaria.rifariaapi.model.Premio;
import com.rifaria.rifariaapi.repository.PremioRepository;

@RestController
public class PremioController {

	@Autowired
	private PremioRepository repo;
	
	@PostMapping(value = "/premio")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Premio salvar(@RequestBody Premio premio) {
		return repo.save(premio);
	}
	
	@GetMapping(value = "/premio")
	public List<Premio> getAllPremios() throws Exception {
		return repo.findAll();
	}
	
	@GetMapping(value = "/premio/{id}")
	public Premio findByPremioId(@PathVariable Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrada"));
	}
	
	@DeleteMapping(value = "/premio/{id}")
	public ResponseEntity<?> deletePremio(@PathVariable Integer id) throws Exception {
		return repo.findById(id).map(premio -> {
			repo.delete(premio);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrado"));
	}
	
	@PutMapping(value = "/premio/{id}")
	public ResponseEntity<Premio> updatePremio(@PathVariable Integer id, @RequestBody Premio newPremio) throws Exception {
		return repo.findById(id).map(premio -> {
			premio.setTitulo(newPremio.getTitulo());
			premio.setValor(newPremio.getValor());
			repo.save(premio);
			return ResponseEntity.ok(premio);
		}).orElseThrow(() -> new Exception("Premio [id = " + id + "] não foi encontrado"));
	}
}
