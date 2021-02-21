package com.rifaria.rifariaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Prize;
import com.rifaria.rifariaapi.model.Raffle;
import com.rifaria.rifariaapi.repository.RaffleRepository;

import DTO.RaffleDTO;

@Service
public class RaffleService {

	@Autowired
	private RaffleRepository repo;
	
	@Autowired
	private PrizeService prizeService;
	
	public Raffle saveRaffle(RaffleDTO rifaDTO) {
		Optional<Prize> prize = prizeService.findById(rifaDTO.getPrize());
		if (prize.isPresent()) {
			Raffle raffle = new Raffle(rifaDTO.getNumber(), prize.get());
			return repo.save(raffle);
		}
		return null;
	}
}
