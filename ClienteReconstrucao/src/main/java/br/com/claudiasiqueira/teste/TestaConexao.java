package br.com.claudiasiqueira.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.claudiasiqueira.dao.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
		Connection conn = new Conexao().conectarBD();
		System.out.println("Conexão Aberta");
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
