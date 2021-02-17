package com.rifaria.rifariaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Premio;
import com.rifaria.rifariaapi.model.Rifa;
import com.rifaria.rifariaapi.repository.RifaRepository;

import DTO.RifaDTO;

@Service
public class RifaService {

	@Autowired
	private RifaRepository repo;
	
	@Autowired
	private PremioService premioService;
	
	public Object salvarRifa(RifaDTO rifaDTO) {
		Optional<Premio> premio = premioService.findById(rifaDTO.getPremio());
		if (premio.isPresent()) {
			Rifa rifa = new Rifa(rifaDTO.getNumero(), premio.get());
			return repo.save(rifa);
		}
		return new Exception("Erro ao cadastrar Rifa com premio inexistente");
	}
}
