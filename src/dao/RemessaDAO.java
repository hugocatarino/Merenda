package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Remessa;

public class RemessaDAO {
	private Connection conexao;
	
	public RemessaDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionaRemessa(Remessa remessa) {
		try {
			String sql = "INSERT INTO `Merenda`.`Remessa` (nome_Alimento, Escola_idEscola, tipo, peso_liq, quantidade, "
				+ "falta, recebido, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			String sql2 = "SELECT idRemessa FROM `Merenda`.`Remessa` ORDER BY idRemessa DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setString(1, remessa.getNomeAlimento());
			stmt.setInt(2, remessa.getIdEscola());
			stmt.setInt(3, remessa.getTipo());
			stmt.setFloat(4, remessa.getPeso_liq());
			stmt.setInt(5, remessa.getQuantidade());
			stmt.setInt(6, remessa.getFalta());
			stmt.setFloat(7, remessa.getRecebido());
			stmt.setString(8, remessa.getDate());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				remessa.setIdRemessa(rs.getInt("idRemessa"));
			}
			System.out.println("Remessa adicionada com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar remessa");
		}
	}
	
	public void removeRemessa(int id) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa` WHERE idRemessa = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, id);
			stmt.execute();
			stmt2.execute();
			stmt.close();
			stmt2.close();
			System.out.println("Remessa removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover remessa");
		}
	}
	
	public Remessa getLastRemessa() {
		Remessa remessa = new Remessa();
		try {
			String sql = "SELECT idRemessa, nome_Alimento, Escola_idEscola, tipo, peso_liq, quantidade, "
				+ "falta, recebido, date FROM `Merenda`.`Remessa` ORDER BY idRemessa DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				remessa.setIdRemessa(rs.getInt("idRemessa"));
				remessa.setIdEscola(rs.getInt("Escola_idEscola"));
				remessa.setNomeAlimento(rs.getString("nome_Alimento"));
				remessa.setTipo(rs.getInt("tipo"));
				remessa.setPeso_liq(rs.getFloat("peso_liq"));
				remessa.setQuantidade(rs.getInt("quantidade"));
				remessa.setFalta(rs.getInt("falta"));
				remessa.setRecebido(rs.getFloat("recebido"));
				remessa.setDate(rs.getString("date"));
			}
			rs.close();
			stmt.close();
//			System.out.println("ID GAME = " + game.getIdGame());
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return remessa;
	}
	
}
