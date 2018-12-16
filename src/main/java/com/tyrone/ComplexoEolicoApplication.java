package com.tyrone;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tyrone.domain.Aerogerador;
import com.tyrone.domain.ComplexoEolico;
import com.tyrone.domain.ParqueEolico;
import com.tyrone.repositories.AerogeradorRepository;
import com.tyrone.repositories.ComplexoEolicoRepository;
import com.tyrone.repositories.ParqueEolicoRepository;

@SpringBootApplication
public class ComplexoEolicoApplication implements CommandLineRunner{

	@Autowired
	private ComplexoEolicoRepository complexoEolicoRepository;
	
	@Autowired
	private ParqueEolicoRepository parqueEolicoRepository;
	
	@Autowired
	private AerogeradorRepository aerogeradorRepository;
	
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
		
		Aerogerador a1 = new Aerogerador(null, "Aerogerador A14", 1234.0, 1234.0, 50.4, 12.8, "xyz", p1);
		Aerogerador a2 = new Aerogerador(null, "Aerogerador A01", 1234.0, 1234.0, 50.4, 12.8, "xyz", p1);
		Aerogerador a3 = new Aerogerador(null, "Aerogerador B99", 1234.0, 1234.0, 50.4, 12.8, "xyz", p2);
		Aerogerador a4 = new Aerogerador(null, "Aerogerador C34", 1234.0, 1234.0, 73.7, 18.4, "alfa+", p3);
		Aerogerador a5 = new Aerogerador(null, "Aerogerador C10", 1234.0, 1234.0, 73.7, 18.4, "alfa+", p3);
		Aerogerador a6 = new Aerogerador(null, "Aerogerador C25", 1234.0, 1234.0, 73.7, 18.4, "alfa+", p3);
		Aerogerador a7 = new Aerogerador(null, "Aerogerador D50", 1234.0, 1234.0, 50.4, 12.8, "xyz", p4);
		
		c1.getParques().addAll(Arrays.asList(p1, p2, p3));
		c2.getParques().addAll(Arrays.asList(p4));
		
		p1.getAerogeradores().addAll(Arrays.asList(a1, a2));
		p2.getAerogeradores().addAll(Arrays.asList(a3));
		p3.getAerogeradores().addAll(Arrays.asList(a4, a5, a6));
		p4.getAerogeradores().addAll(Arrays.asList(a7));
		
		complexoEolicoRepository.saveAll(Arrays.asList(c1, c2));
		parqueEolicoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		aerogeradorRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7));
		
	}

}

