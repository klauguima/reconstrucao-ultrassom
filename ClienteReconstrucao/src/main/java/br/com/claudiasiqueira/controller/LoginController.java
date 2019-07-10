package br.com.claudiasiqueira.controller;

import br.com.claudiasiqueira.dao.UsuarioDB;

public class LoginController {

	public boolean verificarLogin(String login, String senha) {
		UsuarioDB usuarioDB = new UsuarioDB();
		return usuarioDB.consultarUsuario(login, senha);
	}

}
