package com.tyrone.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/complexos")
public class ComplexoEolicoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String foo() {
		return "Bar";
	}
	
}
