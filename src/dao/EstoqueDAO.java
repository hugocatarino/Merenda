
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Estoque;

public class EstoqueDAO {
        private Connection conexao;
        
        public EstoqueDAO() {
            this.conexao = new ConnectionFactory().getConnection();
        }
        
        public void adicionaEstoque(Estoque estoque) {
            	try {
			String sql = "INSERT INTO `Merenda`.`Estoque` (Escola_idEscola, nome)"
				+ "VALUES(?,?)";
			String sql2 = "SELECT idEscola FROM `Merenda`.`Estoque` ORDER BY idEscola DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
                        
                        stmt.setInt(1, estoque.getIdEscola());
                        stmt.setString(2, estoque.getNome());
                        stmt.executeQuery();
                        stmt.close();
                        stmt2.execute();
                        stmt2.close();
                        System.out.println("Estoque adicionado com sucesso!");
                } catch(SQLException sqlException) {
                    System.err.println(sqlException + "Erro ao adicionar Estoque");
                }
        }
        
        public void removeEstoque(int idEstoque) {
                try {
                        String sql = "DELETE FROM `Merenda`.`Estoque` WHERE idEstoque = ?";
                        String sql2 = "ALTER TABLE `Merenda`.`Estoque` AUTO_INCREMENT = 1";
                        PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
                        stmt.setInt(1, idEstoque);
                        stmt.execute();
                        stmt2.execute();
                        stmt.close();
                        
                        System.out.println("Estoque removido com sucesso!");
                } catch(SQLException sqlException) {
                    System.err.println(sqlException + "Erro ao remover Estoque.");
                }
        }
        
        public ArrayList<Estoque> getAllEstoque(int idEscola) {
                ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();
                try {
                        Estoque estoque;
                        String sql = "SELECT * FROM `Merenda`.`Estoque` WHERE Escola_idEscola = ?";
                        PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setInt(1, idEscola);
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next()) {
                                estoque = new Estoque();
                                estoque.setIdEscola(rs.getInt("Escola_idEscola"));
                                estoque.setIdEstoque(rs.getInt("idEstoque"));
                                estoque.setNome(rs.getString("nome"));
                                listaEstoque.add(estoque);
                        }
                } catch(SQLException sqlException) {
                    System.err.println(sqlException + "Erro ao pegar todos estoques.");
                }
                return listaEstoque;
        }
        
        public Estoque buscaEstoque(int idEstoque) {
            Estoque estoque = new Estoque();
            try {
                String sql = "SELECT * FROM `Merenda`.`Estoque` WHERE idEstoque = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
                        stmt.setInt(1, idEstoque);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
                                estoque.setIdEscola(rs.getInt("Escola_idEscola"));
                                estoque.setIdEstoque(rs.getInt("idEstoque"));
                                estoque.setNome(rs.getString("nome"));
                        }
            }catch(SQLException sqlException) {
                System.err.println(sqlException + "Erro ao pegar o ultimo estoque.");
            }
            
            return estoque;
        }
        
        public Estoque getLastEstoque() {
            Estoque estoque = new Estoque();
            try {
                String sql = "SELECT * FROM `Merenda`.`Estoque` ORDER BY idEstoque DESC LIMIT 1";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
                                estoque.setIdEscola(rs.getInt("Escola_idEscola"));
                                estoque.setIdEstoque(rs.getInt("idEstoque"));
                                estoque.setNome(rs.getString("nome"));
                        }
            }catch(SQLException sqlException) {
                System.err.println(sqlException + "Erro ao pegar o ultimo estoque.");
            }
            
            return estoque;
        }
        
}
