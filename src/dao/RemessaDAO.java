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
			String sql = "INSERT INTO `Merenda`.`Remessa` (Estoque_idEstoque, nome, date)"
				+ "VALUES (?, ?, ?)";
			String sql2 = "SELECT idRemessa FROM `Merenda`.`Remessa` ORDER BY idRemessa DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			
			stmt.setInt(1, remessa.getIdEstoque());
			stmt.setString(2, remessa.getNome());
			stmt.setString(3, remessa.getDate());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				remessa.setIdRemessa(rs.getInt("idRemessa"));
			}
//			System.out.println("Remessa adicionada com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar remessa!");
		}
	}
	
	public void removeRemessa(int idRemessa) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa` WHERE idRemessa = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
			dao.removeIdRemessaRemessa_has_Alimento(idRemessa);
			stmt.setInt(1, idRemessa);
			stmt.execute();
                        stmt.close();
                        stmt = this.conexao.prepareStatement(sql2);
                        stmt.execute();
                        stmt.close();
//			System.out.println("Remessa removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover remessa");
		}
	}
	
        public void removeRemessaAlimento(String alimento) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa` WHERE Alimento_nome = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
			dao.removeIdAlimentoRemessa_has_Alimento(alimento);
			stmt.setString(1, alimento);
			stmt.execute();
                        stmt.close();
                        stmt = this.conexao.prepareStatement(sql2);
                        stmt.execute();
                        stmt.close();
//			System.out.println("Remessa removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover remessa");
		}
	}
        
	public Remessa getLastRemessa() {
		Remessa remessa = new Remessa();
		try {
			String sql = "SELECT idRemessa, Estoque_idEstoque, nome, date FROM `Merenda`.`Remessa` ORDER BY idRemessa DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				remessa.setIdRemessa(rs.getInt("idRemessa"));
				remessa.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				remessa.setNome(rs.getString("nome"));
				remessa.setDate(rs.getString("date"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao pegar a ultima remessa!");
		}
		return remessa;
	}
        
        public Remessa getRemessa(int idRemessa) {
		Remessa remessa = new Remessa();
		try {
			String sql = "SELECT idRemessa, Estoque_idEstoque, nome, date FROM `Merenda`.`Remessa` WHERE idRemessa = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setInt(1, idRemessa);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				remessa.setIdRemessa(rs.getInt("idRemessa"));
				remessa.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				remessa.setNome(rs.getString("nome"));
				remessa.setDate(rs.getString("date"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao pegar a ultima remessa!");
		}
		return remessa;
	}


}
