package com.tyrone.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tyrone.domain.ComplexoEolico;
import com.tyrone.services.ComplexoEolicoService;

@RestController
@RequestMapping(value="/complexos")
public class ComplexoEolicoResource {
	
	@Autowired
	private ComplexoEolicoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		ComplexoEolico obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
