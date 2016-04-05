package model;

public class Remessa_has_Alimento {
	private int idRemessa;
	private String idAlimento;
	private int tipo;
	private float peso_liq;
	private int quantidade;
	private int falta;
	private float recebido;

	public int getIdRemessa() {
		return idRemessa;
	}
	public void setIdRemessa(int idRemessa) {
		this.idRemessa = idRemessa;
	}
	public String getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(String idAlimento) {
		this.idAlimento = idAlimento;
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

}
