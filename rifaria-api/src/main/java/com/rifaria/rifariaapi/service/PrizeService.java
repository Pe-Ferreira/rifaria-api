package com.rifaria.rifariaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Prize;
import com.rifaria.rifariaapi.repository.PrizeRepository;

@Service
public class PrizeService {

	@Autowired
	private PrizeRepository repo;
	
	@SuppressWarnings("unused")
	public Optional<Prize> findById(int id) {
		return repo.findById(id);
	}
}
