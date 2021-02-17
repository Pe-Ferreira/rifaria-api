package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "rifa")
@Entity
public class Rifa implements Serializable {

	private static final long serialVersionUID = -6380749575516426900L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private User proprietario;
	
	@Column(name = "numero")
	private int numero;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Premio premio;

	public Rifa() {}
	
	public Rifa(Integer numero, Premio premio) {
		this.numero = numero;
		this.premio = premio;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public User getProprietario() {
//		return proprietario;
//	}
//
//	public void setProprietario(User proprietario) {
//		this.proprietario = proprietario;
//	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}

//	public String toString() {
//		return "{Rifa - ID: " + this.id + " - Proprietário: " + this.proprietario.getEmail() + " - Numero: "
//				+ this.numero + " - Premio: " + this.premio.getTitulo();
//	}
}
