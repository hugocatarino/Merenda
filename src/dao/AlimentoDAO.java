package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alimento;

public class AlimentoDAO {
	Connection conexao;
	
	public AlimentoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionaAlimento(Alimento alimento) {
		try {
			String sql = "INSERT INTO `Merenda`.`Alimento` (nome, Remessa_idRemessa, tipo, peso_liq, quantidade, "
				+ "falta, recebido) VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "SELECT idAlimento FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setString(1, alimento.getNome());
			stmt.setInt(2, alimento.getIdRemessa());
			stmt.setInt(3, alimento.getTipo());
			stmt.setFloat(4, alimento.getPeso_liq());
			stmt.setInt(5, alimento.getQuantidade());
			stmt.setInt(6, alimento.getFalta());
			stmt.setFloat(7, alimento.getRecebido());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
			}
			
			System.out.println("Alimento adicionado com sucesso!");
			
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar elemento");
		}
	}
	
	public void removeRemessa(int id) {
		try {
			String sql = "DELETE FROM `Merenda`.`Alimento` WHERE idAlimento = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, id);
			stmt.execute();
			stmt2.execute();
			stmt.close();
			stmt2.close();
			System.out.println("Alimento removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Alimento");
		}
	}
	
	public Alimento getLastAlimento() {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT idAlimento, nome, Remessa_idRemessa, tipo, peso_liq, quantidade, "
				+ "falta, recebido FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setIdRemessa(rs.getInt("Remessa_idRemessa"));
				alimento.setNome(rs.getString("nome"));
				alimento.setTipo(rs.getInt("tipo"));
				alimento.setPeso_liq(rs.getFloat("peso_liq"));
				alimento.setQuantidade(rs.getInt("quantidade"));
				alimento.setFalta(rs.getInt("falta"));
				alimento.setRecebido(rs.getFloat("recebido"));
			}
			rs.close();
			stmt.close();
//			System.out.println("ID GAME = " + game.getIdGame());
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return alimento;
	}
	
}
