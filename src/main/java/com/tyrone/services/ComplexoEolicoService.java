package com.tyrone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyrone.domain.ComplexoEolico;
import com.tyrone.repositories.ComplexoEolicoRepository;
import com.tyrone.services.exceptions.ObjectNotFoundException;

@Service
public class ComplexoEolicoService {

	@Autowired
	private ComplexoEolicoRepository repository;
	
	public ComplexoEolico findById(Integer id) {
		Optional<ComplexoEolico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + ComplexoEolico.class.getName()));
	}
}
