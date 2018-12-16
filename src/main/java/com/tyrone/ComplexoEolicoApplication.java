package com.tyrone;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tyrone.domain.ComplexoEolico;
import com.tyrone.repositories.ComplexoEolicoRepository;

@SpringBootApplication
public class ComplexoEolicoApplication implements CommandLineRunner{

	@Autowired
	private ComplexoEolicoRepository complexoEolicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ComplexoEolicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ComplexoEolico c1 = new ComplexoEolico(null, "Complexo 1", "RN", "CE1");
		ComplexoEolico c2 = new ComplexoEolico(null, "Complexo 2", "CE", "CE2");
		
		complexoEolicoRepository.saveAll(Arrays.asList(c1, c2));
	}

}

