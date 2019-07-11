package br.com.claudiasiqueira.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.claudiasiqueira.controller.LoginController;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		String login = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		LoginController loginController = new LoginController(request);
		boolean acesso = loginController.verificarLogin(login, senha);
		
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("sucesso", acesso);
		String retornoJson = new Gson().toJson(retorno);
		saida.print(retornoJson);
	}

}
