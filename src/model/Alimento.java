package model;

public class Alimento {
	private int idAlimento;
	private int idEstoque;
	private String nome;
	private int tipo;
	private float peso_liq;
	private float quantidade;
	private int falta;
	private float recebido;

	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
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
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
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
