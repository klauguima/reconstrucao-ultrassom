package br.com.claudiasiqueira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.claudiasiqueira.model.Usuario;

public class UsuarioDB {

	public Usuario consultarUsuario(String login, String senha) {
		boolean autenticado = false;
		String sql;
		
		Usuario usuario = null;
		
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
				usuario = new Usuario();
				
				int usuario_id = result.getInt("usuario_id");
				String usuario_nickname = result.getString("usuario_nickname");
				
				usuario.setId(usuario_id);
				usuario.setNickName(usuario_nickname);
				
			}
			statement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
		
	}

}
