package com.rifaria.rifariaapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "user")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -6759774343110776659L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	private Integer id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Raffle> raffles = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Raffle> getRaffles() {
		return raffles;
	}

	public void setRaffles(List<Raffle> raffles) {
		this.raffles = raffles;
	}
}
