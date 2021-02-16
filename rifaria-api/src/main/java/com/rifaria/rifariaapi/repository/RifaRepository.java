package com.rifaria.rifariaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rifaria.rifariaapi.model.Rifa;

public interface RifaRepository extends JpaRepository<Rifa, Integer>{
	Page<Rifa> findById(Integer id, Pageable pageable);
}
