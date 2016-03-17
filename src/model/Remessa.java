package model;

public class Remessa {
	private int idRemessa;
	private int idEstoque;
	private String nome;
	private String date;

	public int getIdRemessa() {
		return idRemessa;
	}
	public void setIdRemessa(int idRemessa) {
		this.idRemessa = idRemessa;
	}
	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
