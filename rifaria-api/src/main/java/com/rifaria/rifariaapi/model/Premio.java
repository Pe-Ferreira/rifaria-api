package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "premio")
@Entity
public class Premio implements Serializable {
	
	private static final long serialVersionUID = -6380749575516426900L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "valor")
	private double valor;
	
//	@OneToOne(mappedBy = "premio")
//	private Rifa rifa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
