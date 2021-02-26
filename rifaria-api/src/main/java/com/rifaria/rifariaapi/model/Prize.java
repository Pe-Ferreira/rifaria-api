package com.rifaria.rifariaapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "prize")
@Entity
@Getter @Setter
public class Prize implements Serializable {
	
	private static final long serialVersionUID = -6380749575516426900L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "value")
	private double value;

	@Column(name = "max_raffle_amount")
	private Integer maxRaffleAmount;

}
