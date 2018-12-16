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

import com.tyrone.domain.ParqueEolico;
import com.tyrone.services.ParqueEolicoService;

@RestController
@RequestMapping(value="/parques")
public class ParqueEolicoResource {
	
	@Autowired
	private ParqueEolicoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ParqueEolico> findById(@PathVariable Integer id) {
		ParqueEolico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ParqueEolico>> findAll() {
		List<ParqueEolico> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ParqueEolico obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ParqueEolico obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	








}

