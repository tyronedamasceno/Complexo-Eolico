package com.tyrone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tyrone.domain.ComplexoEolico;
import com.tyrone.repositories.ComplexoEolicoRepository;
import com.tyrone.services.exceptions.DataIntegrityException;
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
	
	public List<ComplexoEolico> findAll() {
		return repository.findAll();
	}
	
	public ComplexoEolico insert(ComplexoEolico obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public ComplexoEolico update(ComplexoEolico obj) {
		ComplexoEolico newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível um Complexo eólico que possui parques eólicos");
		}
	}
	
	private void updateData(ComplexoEolico newObj, ComplexoEolico obj) {
		if (obj.getNome() != null) newObj.setNome(obj.getNome());
		if (obj.getIdentificador() != null) newObj.setIdentificador(obj.getIdentificador());
		if (obj.getUf() != null) newObj.setUf(obj.getUf());
	}
	
}
