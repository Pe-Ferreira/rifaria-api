package com.rifaria.rifariaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Premio;
import com.rifaria.rifariaapi.model.Rifa;
import com.rifaria.rifariaapi.repository.RifaRepository;

@Service
public class RifaService {

	@Autowired
	private RifaRepository repo;
	
	@Autowired
	private PremioService premioService;
	
	public Rifa salvarRifa(Rifa rifa) {
//		Optional<Premio> premio = premioService.findById(premioId);
		return repo.save(rifa);
	}
}
