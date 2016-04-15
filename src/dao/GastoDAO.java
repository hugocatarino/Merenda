package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Gasto;

public class GastoDAO {
	private Connection conexao;
	
	public GastoDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	public void adicionaGasto(Gasto gasto) {
		try {
			AlimentoDAO dao = new AlimentoDAO();
			String sql = "INSERT INTO `Merenda`.`Gasto` (Alimento_nome, Mapa_Merenda_idMapa_Merenda, peso) "
				+ "VALUES (?,?,?)";
			String sql2 = "SELECT idGasto FROM `Merenda`.`Gasto` ORDER BY idGasto DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setString(1, gasto.getIdAlimento());
			stmt.setInt(2, gasto.getIdMapa_Merenda());
			stmt.setFloat(3, gasto.getPeso());
			stmt.execute();
			stmt.close();
			ResultSet rs = stmt2.executeQuery();
			if(rs.next()) {
				dao.modificaCusto(gasto.getIdAlimento(), gasto.getPeso());
				gasto.setIdGasto(rs.getInt("idGasto"));
			}
			
			System.out.println("Gasto adicionado com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao adicionar gasto!");
		}
	}
	
	public void removeGasto(int idGasto) {
		try {
			String sql = "DELETE FROM `Merenda`.`Gasto` WHERE idGasto = ?";
			String sql2 = "ALTER TABLE `Merenda`.`Gasto` AUTO_INCREMENT = 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			stmt.setInt(1, idGasto);
			stmt.execute();
			stmt.close();
			stmt2.execute();
			stmt2.close();
			System.out.println("Gasto removido com sucesso!");
		} catch (SQLException sqlException) {
			System.err.println(sqlException + "Erro ao remover Gasto!");
		}
	}
	
        public Gasto GetGastoAlimento(String idAlimento) {
                try {
                        Gasto gasto = new Gasto();
                        String sql = "SELECT * FROM `Merenda`.`Gasto` WHERE Alimento_idAlimento = ?";
                        PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setString(1, idAlimento);
                        ResultSet rs = stmt.executeQuery();
                        gasto.setIdAlimento(rs.getString("Alimento_idAlimento"));
                        gasto.setIdGasto(rs.getInt("idGasto"));
                        gasto.setIdMapa_Merenda(rs.getInt("Mapa_Merenda_idMapa_Merenda"));
                        gasto.setPeso(rs.getFloat("peso"));
                        return gasto;
                        
                } catch(SQLException sqlException) {
                        System.err.println(sqlException + "Erro ao pegar o gasto do alimento" + idAlimento);
                        return null;
                }
        }
        
	public Gasto GetLastGasto() {
		Gasto gasto = new Gasto();
		try {
			String sql = "SELECT idGasto, Alimento_nome, Mapa_Merenda_idMapa_Merenda, peso "
					+ "FROM `Merenda`.`Gasto` ORDER BY idGasto DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				gasto.setIdGasto(rs.getInt("idGasto"));
				gasto.setIdAlimento(rs.getString("Alimento_nome"));
				gasto.setIdMapa_Merenda(rs.getInt("Mapa_Merenda_idMapa_Merenda"));
				gasto.setPeso(rs.getInt("peso"));
			}
		} catch(SQLException sqlException) {
			System.err.println(sqlException + "Erro ao pegar o ultimo gasto");
		}
		return gasto;
	}
}
