package com.tyrone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyrone.domain.Aerogerador;

@Repository
public interface AerogeradorRepository extends JpaRepository<Aerogerador, Integer> {
	
}
