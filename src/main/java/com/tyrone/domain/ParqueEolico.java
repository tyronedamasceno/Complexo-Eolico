package com.tyrone.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ParqueEolico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer latitude;
	private Integer longitude;
	private Double potenciaInstalada;
	
	@ManyToOne
	@JoinColumn(name="complexo_eolico_id")
	private ComplexoEolico complexo;
	
	@OneToMany(mappedBy="parque")
	private List<Aerogerador> aerogeradores = new ArrayList<>();
	
	public ParqueEolico() {
		
	}

	public ParqueEolico(Integer id, String nome, Integer latitude, Integer longitude, Double potenciaInstalada,
			ComplexoEolico complexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.potenciaInstalada = potenciaInstalada;
		this.complexo = complexo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Double getPotenciaInstalada() {
		return potenciaInstalada;
	}

	public void setPotenciaInstalada(Double potenciaInstalada) {
		this.potenciaInstalada = potenciaInstalada;
	}
	
	public ComplexoEolico getComplexo() {
		return complexo;
	}

	public void setComplexo(ComplexoEolico complexo) {
		this.complexo = complexo;
	}

	public List<Aerogerador> getAerogeradores() {
		return aerogeradores;
	}

	public void setAerogeradores(List<Aerogerador> aerogeradores) {
		this.aerogeradores = aerogeradores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParqueEolico other = (ParqueEolico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
