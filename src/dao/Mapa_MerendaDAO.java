package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Mapa_Merenda;

public class Mapa_MerendaDAO {
	private Connection conexao;
	
	public Mapa_MerendaDAO() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adicionaMapa_Merenda(Mapa_Merenda mapa) {
		try {
			String sql = "INSERT INTO `Merenda`.`Mapa_Merenda` (Estoque_idEstoque, cardapio, turno, "
					+ "numero_Alunos, date) VALUES (?, ?, ?, ?, ?)";
			String sql2 = "SELECT idMapa_Merenda FROM `Merenda`.`Mapa_Merenda` ORDER BY idMapa_Merenda DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, mapa.getIdEstoque());
			stmt.setString(2, mapa.getCardapio());
			stmt.setString(3, mapa.getTurno());
			stmt.setInt(4, mapa.getNumero_Aluno());
			stmt.setString(5, mapa.getDate());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				mapa.setIdMapa_Merenda(rs.getInt("idMapa_Merenda"));
			}
			stmt2.close();
			rs.close();
//			System.out.println("Mapa da merenda adicionado com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar mapa da merenda!");
		}
		
	}
	
	public void removeMapa_Merenda(int id) {
		try {
			String sql = "DELETE FROM `Merenda`.`Mapa_Merenda` WHERE idMapa_Merenda = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			stmt2.execute();
			stmt2.close();
//			System.out.println("Mapa da merenda removido com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar mapa da merenda!");
		}
		
	}
	
	public Mapa_Merenda getLastMapa_Merenda() {
		Mapa_Merenda mapa = new Mapa_Merenda();
		try {
			String sql = "SELECT idMapa_Merenda, Estoque_idEstoque, cardapio, turno, "
					+ "numero_Alunos, date FROM `Merenda`.`Mapa_Merenda`"
					+ "ORDER BY idMapa_Merenda DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				mapa.setIdMapa_Merenda(rs.getInt("idMapa_Merenda"));
				mapa.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				mapa.setCardapio(rs.getString("cardapio"));
				mapa.setTurno(rs.getString("Turno"));
				mapa.setNumero_Aluno(rs.getInt("numero_Alunos"));
				mapa.setDate(rs.getString("date"));
				
			}
			stmt.close();
			rs.close();
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao pegar ultimo mapa da merenda!");
		}
		return mapa;
	}
	
	
	
	
}
