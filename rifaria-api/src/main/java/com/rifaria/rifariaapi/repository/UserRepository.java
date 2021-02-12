package com.rifaria.rifariaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rifaria.rifariaapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Page<User> findById(Integer id, Pageable pageable);

}
