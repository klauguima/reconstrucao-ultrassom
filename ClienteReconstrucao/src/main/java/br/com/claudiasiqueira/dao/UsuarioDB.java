package br.com.claudiasiqueira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDB {

//	public void inserirUsuario() {
//
//		Connection conn = new Conexao().conectarBD();
//
//		String sql = "insert	into usuarios" + "	(id,nome,cpf,senha,email)" + "	values	(?,?,?,?)";
//	}

	public boolean consultarUsuario(String login, String senha) {
		boolean autenticado = false;
		String sql;
		String acesso;
		try {

			Connection conn = new Conexao().conectarBD();

			sql = "SELECT usuario_id, usuario_nickname FROM usuarios WHERE usuario_nickname = ? "
					+ "AND usuario_senha = SHA1(?)";

			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, senha);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				acesso = result.getString("usuario_id");
				autenticado = true;
			}
			statement.close();
			return autenticado;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return autenticado;
	}

}
