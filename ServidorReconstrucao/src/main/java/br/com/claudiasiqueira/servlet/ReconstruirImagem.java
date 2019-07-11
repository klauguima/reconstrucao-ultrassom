package br.com.claudiasiqueira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.claudiasiqueira.controller.ReconstrucaoController;

@WebServlet("/reconstruir_imagem")//url que esta sendo chamada
public class ReconstruirImagem extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hFilePath = req.getParameter("hFilePath");
		
		new ReconstrucaoController(resp).reconstruir(hFilePath);
	}

}
