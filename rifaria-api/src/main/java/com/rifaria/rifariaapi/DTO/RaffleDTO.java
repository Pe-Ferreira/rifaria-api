package com.rifaria.rifariaapi.DTO;

public class RaffleDTO {

	private Integer id;
	private Integer number;
	private Integer prize;
	
	public RaffleDTO(Integer id, Integer number, Integer prize) {
		this.id = id;
		this.number = number;
		this.prize = prize;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getPrize() {
		return prize;
	}
	public void setPrize(Integer prize) {
		this.prize = prize;
	}
	
	
}
