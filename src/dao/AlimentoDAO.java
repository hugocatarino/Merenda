package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alimento;

public class AlimentoDAO {
	Connection conexao;
	
	public AlimentoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionaAlimento(Alimento alimento) {
		try {
			String sql = "INSERT INTO `Merenda`.`Alimento` (nome, Estoque_idEstoque, total) VALUES (?, ?, ?)";
			String sql2 = "SELECT idAlimento FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, alimento.getNome());
			stmt.setInt(2, alimento.getIdEstoque());
			stmt.setFloat(3, alimento.getTotal());
			stmt.execute();
			stmt.close();
			stmt = this.conexao.prepareStatement(sql2);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
			}
			stmt.execute();
			stmt.close();
			System.out.println("Alimento adicionado com sucesso!");
			
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar elemento");
		}
	}
	
	public void removeAlimento(int idAlimento) {
		try {
			String sql = "DELETE FROM `Merenda`.`Alimento` WHERE idAlimento = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			Remessa_has_AlimentoDAO dao = new Remessa_has_AlimentoDAO();
			dao.removeIdAlimentoRemessa_has_Alimento(idAlimento);
			stmt.setInt(1, idAlimento);
			stmt.execute();
			stmt.close();
			stmt = this.conexao.prepareStatement(sql2);
			stmt.execute();
			stmt.close();
			System.out.println("Alimento removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Alimento");
		}
	}
	
	public Alimento buscaAlimento(int idAlimento) {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT * FROM `Merenda`.`Alimento` WHERE idAlimento = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, idAlimento);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setNome(rs.getString("nome"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setTotal(rs.getFloat("total"));
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
//				float novo = alimento.getQuantidade() - (custo/alimento.getPeso_liq());
				String sql = "UPDATE `Merenda`.`Alimento` SET quantidade = ? WHERE idAlimento = ?";
				PreparedStatement stmt = this.conexao.prepareStatement(sql);
//				stmt.setFloat(1, novo);
				stmt.setInt(2, idAlimento);
				stmt.execute();
				stmt.close();
			}
		}catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao modificar o custo!");
		}
	}
	
	public ArrayList<Alimento> getAllAlimento() {
		ArrayList<Alimento> listaAlimento = new ArrayList<Alimento>();
		try {
			String sql = "SELECT * FROM `Merenda`.`Alimento`";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setNome(rs.getString("nome"));
				alimento.setTotal(rs.getFloat("total"));
				listaAlimento.add(alimento);
			}
			rs.close();
			stmt.close();
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return listaAlimento;
	}
	
	public Alimento getLastAlimento() {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT * FROM `Merenda`.`Alimento` ORDER BY idAlimento DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setIdAlimento(rs.getInt("idAlimento"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setNome(rs.getString("nome"));
				alimento.setTotal(rs.getFloat("total"));
			}
			rs.close();
			stmt.close();
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return alimento;
	}

}
