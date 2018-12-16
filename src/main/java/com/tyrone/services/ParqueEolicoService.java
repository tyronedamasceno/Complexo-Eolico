package com.tyrone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tyrone.domain.Aerogerador;
import com.tyrone.domain.ParqueEolico;
import com.tyrone.repositories.ParqueEolicoRepository;
import com.tyrone.services.exceptions.DataIntegrityException;
import com.tyrone.services.exceptions.ObjectNotFoundException;

@Service
public class ParqueEolicoService {

	@Autowired
	private ParqueEolicoRepository repository;
	
	public ParqueEolico findById(Integer id) {
		Optional<ParqueEolico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + ParqueEolico.class.getName()));
	}
	
	public List<ParqueEolico> findAll() {
		return repository.findAll();
	}
	
	public ParqueEolico insert(ParqueEolico obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public ParqueEolico update(ParqueEolico obj) {
		ParqueEolico newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover um parque eólico que possui aerogeradores");
		}
	}
	
	public List<Aerogerador> findAerogeradoresInParque(Integer id) {
		ParqueEolico obj = findById(id);
		return obj.getAerogeradores();
	}
	
	private void updateData(ParqueEolico newObj, ParqueEolico obj) {
		if (obj.getNome() != null) newObj.setNome(obj.getNome());
		if (obj.getLatitude() != null) newObj.setLatitude(obj.getLatitude());
		if (obj.getLongitude() != null) newObj.setLongitude(obj.getLongitude());
		if (obj.getPotenciaInstalada() != null) newObj.setPotenciaInstalada(obj.getPotenciaInstalada());
		if (obj.getComplexo() != null) newObj.setComplexo(obj.getComplexo());
	}
	
}
