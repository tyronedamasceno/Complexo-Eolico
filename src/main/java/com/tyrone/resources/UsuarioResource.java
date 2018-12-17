package com.tyrone.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tyrone.domain.Usuario;
import com.tyrone.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="sign-up", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

