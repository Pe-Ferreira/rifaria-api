package com.rifaria.rifariaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rifaria.rifariaapi.model.Premio;

public interface PremioRepository extends JpaRepository<Premio, Integer>{
	Page<Premio> findById(Integer id, Pageable pageable);
}
