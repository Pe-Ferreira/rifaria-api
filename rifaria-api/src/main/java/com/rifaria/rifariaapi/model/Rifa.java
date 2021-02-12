package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "rifa")
@Entity
public class Rifa implements Serializable {

	private static final long serialVersionUID = -6380749575516426900L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", insertable = false, updatable = false)
	private Long id;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private User proprietario;
	
	@Column(name = "numero")
	private int numero;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "premio_id", referencedColumnName = "id")
//	private Premio premio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

//	public Premio getPremio() {
//		return premio;
//	}
//
//	public void setPremio(Premio premio) {
//		this.premio = premio;
//	}

//	public String toString() {
//		return "{Rifa - ID: " + this.id + " - Proprietário: " + this.proprietario.getEmail() + " - Numero: "
//				+ this.numero + " - Premio: " + this.premio.getTitulo();
//	}
}