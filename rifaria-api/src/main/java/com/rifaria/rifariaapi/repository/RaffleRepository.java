package com.rifaria.rifariaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rifaria.rifariaapi.model.Raffle;

public interface RaffleRepository extends JpaRepository<Raffle, Integer>{
	Page<Raffle> findById(Integer id, Pageable pageable);
}
