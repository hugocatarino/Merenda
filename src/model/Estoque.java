package model;

public class Estoque {
	private int idEstoque;
	private int idEscola;
        private String nome;

	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}
	public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                this.nome = nome;
        }
}
