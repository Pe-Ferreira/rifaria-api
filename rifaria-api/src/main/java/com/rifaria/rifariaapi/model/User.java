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

import lombok.Getter;
import lombok.Setter;

@Table(name = "user")
@Entity
@Getter @Setter
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
	
}
