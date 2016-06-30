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
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, alimento.getNome());
			stmt.setInt(2, alimento.getIdEstoque());
			stmt.setFloat(3, alimento.getTotal());
			stmt.execute();
			stmt.close();
			//System.out.println("Alimento adicionado com sucesso!");
			
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar elemento");
		}
	}
	
	public void removeAlimento(String nomeAlimento) {
		try {
			String sql = "DELETE FROM `Merenda`.`Alimento` WHERE nome = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			Remessa_has_AlimentoDAO daoRemessaAlimento = new Remessa_has_AlimentoDAO();
			daoRemessaAlimento.removeIdAlimentoRemessa_has_Alimento(nomeAlimento);
			stmt.setString(1, nomeAlimento);
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
	
	public Alimento buscaAlimento(String nomeAlimento) {
		Alimento alimento = new Alimento();
		try {
			String sql = "SELECT * FROM `Merenda`.`Alimento` WHERE nome = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, nomeAlimento);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setNome(rs.getString("nome"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
				alimento.setTotal(rs.getFloat("total"));
			}
		}catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao BUSCAR alimento!");
		}
		return alimento;
	}
	
	public void modificaCusto(String nomeAlimento, float custo) {
		try {
			Alimento alimento = buscaAlimento(nomeAlimento);
			float novo = alimento.getTotal() - custo;
			if(alimento != null) {
				String sql = "UPDATE `Merenda`.`Alimento` SET total = ? WHERE nome = ?";
				PreparedStatement stmt = this.conexao.prepareStatement(sql);
				stmt.setFloat(1, novo);
				stmt.setString(2, nomeAlimento);
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
        
        public ArrayList<Alimento> getAllAlimentoEstoque(int idEstoque) {
		ArrayList<Alimento> listaAlimento = new ArrayList<Alimento>();
		try {
			String sql = "SELECT * FROM `Merenda`.`Alimento` WHERE Estoque_idEstoque = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setInt(1, idEstoque);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setNome(rs.getString("nome"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
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
			String sql = "SELECT * FROM `Merenda`.`Alimento` ORDER BY nome DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				alimento.setNome(rs.getString("nome"));
				alimento.setIdEstoque(rs.getInt("Estoque_idEstoque"));
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