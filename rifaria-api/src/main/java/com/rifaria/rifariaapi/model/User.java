package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "senha")
	private String senha;
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Rifa> listaDeRifas = new ArrayList<>();
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
