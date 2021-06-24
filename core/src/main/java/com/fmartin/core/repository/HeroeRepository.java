package com.fmartin.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmartin.core.entity.Heroe;

public interface HeroeRepository extends JpaRepository<Heroe, String>{
	
}
