package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Remessa;

import model.Remessa_has_Alimento;

public class Remessa_has_AlimentoDAO {
	Connection conexao;
	
	public Remessa_has_AlimentoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionaRemessa_has_Alimento(Remessa_has_Alimento remessaAlimento) {
		try {
			String sql = "INSERT INTO `Merenda`.`Remessa_has_Alimento` (Remessa_idRemessa, Alimento_nome, tipo, peso_liq, "
					+ "quantidade, falta, recebido) VALUES(?, ?, ?, ?, ?, ?, ?)";
			AlimentoDAO dao = new AlimentoDAO();
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, remessaAlimento.getIdRemessa());
			stmt.setString(2, remessaAlimento.getIdAlimento());
			stmt.setInt(3, remessaAlimento.getTipo());
			stmt.setFloat(4, remessaAlimento.getPeso_liq());
			stmt.setInt(5, remessaAlimento.getQuantidade());
			stmt.setInt(6, remessaAlimento.getFalta());
			stmt.setFloat(7, remessaAlimento.getRecebido());
			stmt.execute();
			stmt.close();
                        dao.modificaCusto(remessaAlimento.getIdAlimento(), (-1) * remessaAlimento.getRecebido());
			System.out.println("Remessa_has_Alimento adicionado com sucesso!");
			
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar Remessa_has_Alimento");
		}
	}
	
	public void removeIdRemessaRemessa_has_Alimento(int idRemessa) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa_has_Alimento` WHERE Remessa_idRemessa = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa_has_Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, idRemessa);
			stmt.execute();
			stmt.close();
			stmt = this.conexao.prepareStatement(sql2);
			stmt.execute();
			stmt.close();
			System.out.println("Remessa_has_Alimento removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Remessa_has_Alimento");
		}
	}

	public void removeIdAlimentoRemessa_has_Alimento(String nomeAlimento) {
		try {
			String sql = "DELETE FROM `Merenda`.`Remessa_has_Alimento` WHERE Alimento_nome = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Remessa_has_Alimento` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, nomeAlimento);
			stmt.execute();
			stmt = this.conexao.prepareStatement(sql2);
			stmt.execute();
			stmt.close();
			System.out.println("Remessa_has_Alimento removida com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Remessa_has_Alimento");
		}
	}
	
	public Remessa_has_Alimento getLastRemessa_has_Alimento() {
		Remessa_has_Alimento remessaAlimento = new Remessa_has_Alimento();
		try {
			String sql = "SELECT * FROM `Merenda`.`Remessa_has_Alimento` ORDER BY Alimento_nome DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				remessaAlimento.setIdAlimento(rs.getString("Alimento_nome"));
				remessaAlimento.setIdRemessa(rs.getInt("Remessa_idRemessa"));
				remessaAlimento.setFalta(rs.getInt("falta"));
				remessaAlimento.setPeso_liq(rs.getFloat("peso_liq"));
				remessaAlimento.setQuantidade(rs.getInt("quantidade"));
				remessaAlimento.setRecebido(rs.getFloat("recebido"));
				remessaAlimento.setTipo(rs.getInt("tipo"));
			}
			rs.close();
			stmt.close();
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "erro ao pegar o ultimo!");
		}
		return remessaAlimento;
	}
        
        public ArrayList<Remessa_has_Alimento> getListaRemessaAlimento(String nomeAlimento) {
                ArrayList<Remessa_has_Alimento> listaRemessaAlimento = new ArrayList<Remessa_has_Alimento>();
                Remessa_has_Alimento remessaAlimento;
                try {
			RemessaDAO dao = new RemessaDAO();
                        Remessa remessa;
                        String sql = "SELECT * FROM `Merenda`.`Remessa_has_Alimento` WHERE Alimento_nome = ?";
                        String sql2 = "SELECT nome, date FROM `Merenda`.`Remessa` WHERE idRemessa = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setString(1, nomeAlimento);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
                                remessaAlimento = new Remessa_has_Alimento();
				remessaAlimento.setIdAlimento(rs.getString("Alimento_nome"));
				remessaAlimento.setIdRemessa(rs.getInt("Remessa_idRemessa"));
				remessaAlimento.setFalta(rs.getInt("falta"));
				remessaAlimento.setPeso_liq(rs.getFloat("peso_liq"));
				remessaAlimento.setQuantidade(rs.getInt("quantidade"));
				remessaAlimento.setRecebido(rs.getFloat("recebido"));
				remessaAlimento.setTipo(rs.getInt("tipo"));
                                remessa = dao.getRemessa(remessaAlimento.getIdRemessa());
                                remessaAlimento.setDateRemessa(remessa.getDate());
                                remessaAlimento.setNomeRemessa(remessa.getNome());
                                listaRemessaAlimento.add(remessaAlimento);
			}
			rs.close();
			stmt.close();
                        
		} catch(SQLException sqlException) {
			System.err.println(sqlException + " Erro ao pegar a Lista de RemessaAlimento!");
		}
                return listaRemessaAlimento;
        }

}

