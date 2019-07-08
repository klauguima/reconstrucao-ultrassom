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

import br.com.claudiasiqueira.controller.ReconstrucaoController;

@WebServlet("/reconstruir_imagem")
public class ReconstruirImagem extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hFilePath = req.getParameter("hFilePath");
		
		new ReconstrucaoController(resp).reconstruir(hFilePath);
	}

}
