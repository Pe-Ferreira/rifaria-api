package com.rifaria.rifariaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rifaria.rifariaapi.model.Prize;

public interface PrizeRepository extends JpaRepository<Prize, Integer>{
	Page<Prize> findById(Integer id, Pageable pageable);
}
