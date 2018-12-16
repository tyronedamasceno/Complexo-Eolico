package com.tyrone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyrone.domain.ParqueEolico;

@Repository
public interface ParqueEolicoRepository extends JpaRepository<ParqueEolico, Integer> {
	
}
