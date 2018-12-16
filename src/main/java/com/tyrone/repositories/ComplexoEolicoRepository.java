package com.tyrone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyrone.domain.ComplexoEolico;

@Repository
public interface ComplexoEolicoRepository extends JpaRepository<ComplexoEolico, Integer> {
	
}
