package model;

public class Gasto {
	private int idGasto;
	private int idMapa_Merenda;
	private String idAlimento;
	private float peso;
	
	public int getIdGasto() {
		return idGasto;
	}
	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}
	public int getIdMapa_Merenda() {
		return idMapa_Merenda;
	}
	public void setIdMapa_Merenda(int idMapa_Merenda) {
		this.idMapa_Merenda = idMapa_Merenda;
	}
	public String getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(String idAlimento) {
		this.idAlimento = idAlimento;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}
