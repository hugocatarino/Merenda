package model;

public class Mapa_Merenda {
	private int idMapa_Merenda;
	private int idEstoque;
	private String cardapio;
	private String turno;
	private int numero_Aluno;
	private String date;

	public int getIdMapa_Merenda() {
		return idMapa_Merenda;
	}
	public void setIdMapa_Merenda(int idMapa_Merenda) {
		this.idMapa_Merenda = idMapa_Merenda;
	}
	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public String getCardapio() {
		return cardapio;
	}
	public void setCardapio(String cardapio) {
		this.cardapio = cardapio;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getNumero_Aluno() {
		return numero_Aluno;
	}
	public void setNumero_Aluno(int numero_Aluno) {
		this.numero_Aluno = numero_Aluno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
