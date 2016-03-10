package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Escola;

public class EscolaDAO {
	private Connection conexao;

	public EscolaDAO() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adicionaEscola(Escola escola) {
		try {
			String sql = "INSERT INTO `Merenda`.`Escola` (nome)"
				+ "VALUES(?)";
			String sql2 = "SELECT idEscola FROM `Merenda`.`Escola` ORDER BY idEscola DESC LIMIT 1";
			
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setString(1, escola.getNome());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				escola.setIdEscola(rs.getInt("idEscola"));
			}
			stmt2.close();
			rs.close();
			System.out.println("Escola adicionada com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar a Escola.");
			
		}
	}
	
	public void removeEscola(String nome) {
		try {
		String sql = "DELETE FROM `Merenda`.`Escola` WHERE nome = ?";
		String sql2 = "ALTER TABLE `Merenda`.`Escola` AUTO_INCREMENT = 1";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
		stmt.setString(1, nome);
		stmt.execute();
		stmt2.execute();
		stmt.close();
		stmt2.close();
		System.out.println("Escola removida com sucesso!");
			stmt = this.conexao.prepareStatement(sql);
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover a Escola do banco de dados.");
		}
		
	}
	
}
