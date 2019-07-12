package br.com.claudiasiqueira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.claudiasiqueira.utils.OutputUtils;

@WebServlet("/imagerender")
public class ImageRender extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caminhoImagem = request.getParameter("caminhoImagem");
		new OutputUtils(response).writeOutputFile(caminhoImagem);
	}
	
}
