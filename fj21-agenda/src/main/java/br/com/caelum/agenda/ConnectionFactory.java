package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
