package com.tyrone;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tyrone.domain.ComplexoEolico;
import com.tyrone.domain.ParqueEolico;
import com.tyrone.repositories.ComplexoEolicoRepository;
import com.tyrone.repositories.ParqueEolicoRepository;

@SpringBootApplication
public class ComplexoEolicoApplication implements CommandLineRunner{

	@Autowired
	private ComplexoEolicoRepository complexoEolicoRepository;
	
	@Autowired
	private ParqueEolicoRepository parqueEolicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ComplexoEolicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ComplexoEolico c1 = new ComplexoEolico(null, "Complexo 1", "RN", "CE1");
		ComplexoEolico c2 = new ComplexoEolico(null, "Complexo 2", "CE", "CE2");
		
		ParqueEolico p1 = new ParqueEolico(null, "Parque A", 1234, 4321, 822.4, c1);
		ParqueEolico p2 = new ParqueEolico(null, "Parque B", 5678, 8765, 1021.72, c1);
		ParqueEolico p3 = new ParqueEolico(null, "Parque C", 2468, 8624, 45.0, c1);
		ParqueEolico p4 = new ParqueEolico(null, "Parque D", 1357, 7531, 2854.99, c2);
		
		c1.getParques().addAll(Arrays.asList(p1, p2, p3));
		c2.getParques().addAll(Arrays.asList(p4));
		
		complexoEolicoRepository.saveAll(Arrays.asList(c1, c2));
		parqueEolicoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	
	}

}

