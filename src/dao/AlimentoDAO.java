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
	
	public void adicionaAlimento(Alimento alimento, int idRemessa) {
		try {
			String sql = "INSERT INTO `Merenda`.`Alimento` (nome, Estoque_idEstoque, tipo, peso_liq, quantidade, "
				+ "falta, recebido) VALUES (?, ?, ?, ?, ?, ?, ?);";
			String sql2 = "SELECT idAlimento FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			String sql3 = "INSERT INTO `Merenda`.`Remessa_has_Alimento` (Remessa_idRemessa, Alimento_idAlimento) " +
					"VALUES (?, ?);";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setString(1, alimento.getNome());
			stmt.setInt(2, alimento.getIdEstoque());
			stmt.setInt(3, alimento.getTipo());
			stmt.setFloat(4, alimento.getPeso_liq());
			stmt.setFloat(5, alimento.getQuantidade());
			stmt.setInt(6, alimento.getFalta());
			stmt.setFloat(7, alimento.getRecebido());
			stmt.execute();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
			}
			stmt = this.conexao.prepareStatement(sql3);
			stmt.setInt(1, idRemessa);
			stmt.setInt(2, alimento.getIdAlimento());
			stmt.execute();
			stmt.close();
			System.out.println("Alimento adicionado com sucesso!");
			
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar elemento");
		}
	}
	
	public void removeAlimento(int idAlimento) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa_has_Alimento` WHERE Alimento_idAlimento = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa_has_Alimento` AUTO_INCREMENT = 1";
			String sql3 = "DELETE FROM `Merenda`.`Alimento` WHERE idAlimento = ?";
			String sql4 = "ALTER TABLE `Merenda`.`Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, idAlimento);
			stmt.execute();
			stmt2.execute();
			stmt = this.conexao.prepareStatement(sql3);
			stmt.setInt(1, idAlimento);
			stmt.execute();
			stmt.close();
			stmt2 = this.conexao.prepareStatement(sql4);
			stmt2.execute();
			stmt2.close();
			System.out.println("Alimento removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Alimento");
		}
	}
	
	public Alimento buscaAlimento(int idAlimento) {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT idAlimento, nome, Estoque_idEstoque, tipo, peso_liq, quantidade, "
					+ "falta, recebido FROM `Merenda`.`Alimento` WHERE idAlimento = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, idAlimento);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setNome(rs.getString("nome"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setTipo(rs.getInt("tipo"));
				alimento.setQuantidade(rs.getFloat("quantidade"));
				alimento.setPeso_liq(rs.getFloat("peso_liq"));
				alimento.setFalta(rs.getInt("falta"));
				alimento.setRecebido(rs.getFloat("recebido"));
			}
		}catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao BUSCAR alimento!");
		}
		return alimento;
	}
	
	public void modificaCusto(int idAlimento, float custo) {
		try {
			
			Alimento alimento = buscaAlimento(idAlimento);
			if(alimento != null) {
				float novo = alimento.getQuantidade() - (custo/alimento.getPeso_liq());
				String sql = "UPDATE `Merenda`.`Alimento` SET quantidade = ? WHERE idAlimento = ?";
				PreparedStatement stmt = this.conexao.prepareStatement(sql);
				stmt.setFloat(1, novo);
				stmt.setInt(2, idAlimento);
				stmt.execute();
				stmt.close();
			}
		}catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao modificar o custo!");
		}
	}
	
	public Alimento getLastAlimento() {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT idAlimento, nome, Estoque_idEstoque, tipo, peso_liq, quantidade, "
				+ "falta, recebido FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setNome(rs.getString("nome"));
				alimento.setTipo(rs.getInt("tipo"));
				alimento.setPeso_liq(rs.getFloat("peso_liq"));
				alimento.setQuantidade(rs.getInt("quantidade"));
				alimento.setFalta(rs.getInt("falta"));
				alimento.setRecebido(rs.getFloat("recebido"));
			}
			rs.close();
			stmt.close();
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return alimento;
	}
	
}
