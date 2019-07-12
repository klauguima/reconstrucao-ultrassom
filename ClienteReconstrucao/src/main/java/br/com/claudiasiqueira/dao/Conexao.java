package br.com.claudiasiqueira.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection conectarBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/cliente_reconstrucao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
