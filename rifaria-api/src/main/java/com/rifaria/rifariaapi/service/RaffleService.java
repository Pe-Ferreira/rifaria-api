package com.rifaria.rifariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.DTO.RaffleDTO;
import com.rifaria.rifariaapi.model.Prize;
import com.rifaria.rifariaapi.model.Raffle;
import com.rifaria.rifariaapi.repository.RaffleRepository;

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

	public List<Raffle> findAll() {
		return repo.findAll();
	}

	public Raffle findById(Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Raffle [id = " + id + "] not found"));
	}

	public ResponseEntity<?> delete(Integer id) throws Exception {
		return repo.findById(id).map(raffle -> {
			repo.delete(raffle);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Raffle [id = " + id + "] not found"));
	}

	public ResponseEntity<Raffle> update(Integer id, Raffle newRaffle) throws Exception {
		return repo.findById(id).map(raffle -> {
			raffle.setNumber(newRaffle.getNumber());
			repo.save(raffle);
			return ResponseEntity.ok(raffle);
		}).orElseThrow(() -> new Exception("Raffle [id = " + id + "] not found"));
	}
}
