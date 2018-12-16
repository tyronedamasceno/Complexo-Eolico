package com.tyrone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyrone.domain.Aerogerador;
import com.tyrone.repositories.AerogeradorRepository;
import com.tyrone.services.exceptions.ObjectNotFoundException;

@Service
public class AerogeradorService {

	@Autowired
	private AerogeradorRepository repository;
	
	public Aerogerador findById(Integer id) {
		Optional<Aerogerador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Aerogerador.class.getName()));
	}
	
	public List<Aerogerador> findAll() {
		return repository.findAll();
	}
	
	public Aerogerador insert(Aerogerador obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Aerogerador update(Aerogerador obj) {
		Aerogerador newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
	
	private void updateData(Aerogerador newObj, Aerogerador obj) {
		if (obj.getNome() != null) newObj.setNome(obj.getNome());
		if (obj.getLatitude() != null) newObj.setLatitude(obj.getLatitude());
		if (obj.getLongitude() != null) newObj.setLongitude(obj.getLongitude());
		if (obj.getModelo() != null) newObj.setModelo(obj.getModelo());
		if (obj.getAlturaTorre() != null) newObj.setAlturaTorre(obj.getAlturaTorre());
		if (obj.getDiametroVarredura() != null) newObj.setDiametroVarredura(obj.getDiametroVarredura());
		if (obj.getParque() != null) newObj.setParque(obj.getParque());
	}
	
}
