package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "raffle")
@Entity
public class Raffle implements Serializable {

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
	
	@Column(name = "number")
	private int number;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Prize prize;

	public Raffle() {}
	
	public Raffle(Integer number, Prize prize) {
		this.number = number;
		this.prize = prize;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

//	public String toString() {
//		return "{Rifa - ID: " + this.id + " - Proprietário: " + this.proprietario.getEmail() + " - Numero: "
//				+ this.numero + " - Premio: " + this.premio.getTitulo();
//	}
}
