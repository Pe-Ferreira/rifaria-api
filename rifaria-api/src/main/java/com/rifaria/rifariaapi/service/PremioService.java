package com.rifaria.rifariaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Premio;
import com.rifaria.rifariaapi.repository.PremioRepository;

@Service
public class PremioService {

	@Autowired
	private PremioRepository repo;
	
	@SuppressWarnings("unused")
	public Optional<Premio> findById(int id) {
		return repo.findById(id);
	}
}
