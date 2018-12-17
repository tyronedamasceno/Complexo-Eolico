package com.tyrone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyrone.domain.Usuario;
import com.tyrone.repositories.UsuarioRepository;
import com.tyrone.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setPassword(bCryptPasswordEncoder.encode(obj.getPassword()));
		return repository.save(obj);
	}
	
}
