package br.com.claudiasiqueira.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.claudiasiqueira.dao.UsuarioDB;
import br.com.claudiasiqueira.model.Usuario;

public class LoginController {

	private HttpServletRequest request;
	private HttpSession session;

	public LoginController(HttpServletRequest request) {
		this.request = request;
		session = request.getSession();
	}

	public boolean verificarLogin(String login, String senha) {
		UsuarioDB usuarioDB = new UsuarioDB();
		Usuario usuario = usuarioDB.consultarUsuario(login, senha);
		session.setAttribute("usuario", usuario);
		return usuario != null;
	}
	

}
