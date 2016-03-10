package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mysql?user=root&password=root";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Conexao estabelecida com sucesso!");
			return DriverManager.getConnection(url);
		}catch(SQLException sqlException) {
			System.err.println(sqlException);
			throw new RuntimeException("Erro ao estabelecer uma conexão com o bando de dados!");
		}
	}
}
