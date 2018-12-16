package com.tyrone.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aerogerador implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private Double latitude;
		private Double longitude;
		private Double alturaTorre;
		private Double diametroVarredura;
		private String modelo;
		
		@ManyToOne
		@JoinColumn(name="parque_eolico_id")
		private ParqueEolico parque;
		
		public Aerogerador() {
			
		}

		public Aerogerador(Integer id, String nome, Double latitude, Double longitude, Double alturaTorre,
				Double diametroVarredura, String modelo, ParqueEolico parque) {
			super();
			this.id = id;
			this.nome = nome;
			this.latitude = latitude;
			this.longitude = longitude;
			this.alturaTorre = alturaTorre;
			this.diametroVarredura = diametroVarredura;
			this.modelo = modelo;
			this.parque = parque;
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

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public Double getAlturaTorre() {
			return alturaTorre;
		}

		public void setAlturaTorre(Double alturaTorre) {
			this.alturaTorre = alturaTorre;
		}

		public Double getDiametroVarredura() {
			return diametroVarredura;
		}

		public void setDiametroVarredura(Double diametroVarredura) {
			this.diametroVarredura = diametroVarredura;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public ParqueEolico getParque() {
			return parque;
		}

		public void setParque(ParqueEolico parque) {
			this.parque = parque;
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
			Aerogerador other = (Aerogerador) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		
		
}
