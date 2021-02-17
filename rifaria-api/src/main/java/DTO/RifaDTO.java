package DTO;

public class RifaDTO {

	private Integer id;
	private Integer numero;
	private Integer premio;
	
	public RifaDTO(Integer id, Integer numero, Integer premio) {
		this.id = id;
		this.numero = numero;
		this.premio = premio;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getPremio() {
		return premio;
	}
	public void setPremio(Integer premio) {
		this.premio = premio;
	}
	
	
}
