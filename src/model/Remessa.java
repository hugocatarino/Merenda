package model;

import java.sql.Date;

public class Remessa {
	private int idRemessa;
	private int idEscola;
	private String nomeAlimento;
	private int tipo;
	private float peso_liq;
	private int quantidade;
	private int falta;
	private float recebido;
	private String date;

	public int getIdRemessa() {
		return idRemessa;
	}
	public void setIdRemessa(int idRemessa) {
		this.idRemessa = idRemessa;
	}
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getPeso_liq() {
		return peso_liq;
	}
	public void setPeso_liq(float peso_liq) {
		this.peso_liq = peso_liq;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getFalta() {
		return falta;
	}
	public void setFalta(int falta) {
		this.falta = falta;
	}
	public float getRecebido() {
		return recebido;
	}
	public void setRecebido(float recebido) {
		this.recebido = recebido;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
