package com.rifaria.rifariaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rifaria.rifariaapi.model.Prize;
import com.rifaria.rifariaapi.repository.PrizeRepository;

@Service
public class PrizeService {

	@Autowired
	private PrizeRepository repo;
	
	public Prize save(Prize prize) {
		return repo.save(prize);
	}

	public Optional<Prize> findById(int id) {
		return repo.findById(id);
	}

	public List<Prize> findAll() {
		return repo.findAll();
	}

	public Prize findById(Integer id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Prize [id = " + id + "] not found"));
	}

	public ResponseEntity<?> delete(Integer id) throws Exception {
		return repo.findById(id).map(prize -> {
			repo.delete(prize);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Prize [id = " + id + "] not found"));
	}

	public ResponseEntity<Prize> update(Integer id, Prize newPrize) throws Exception {
		return repo.findById(id).map(prize -> {
			prize.setTitle(newPrize.getTitle());
			prize.setValue(newPrize.getValue());
			repo.save(prize);
			return ResponseEntity.ok(prize);
		}).orElseThrow(() -> new Exception("Prize [id = " + id + "] not found"));
	}
}
