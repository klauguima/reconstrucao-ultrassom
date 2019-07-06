package br.com.claudiasiqueira.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter saida = resp.getWriter();
		 String usuario = req.getParameter("nome");
         String senha = req.getParameter("endereco");
        
		System.out.println("teste");
	}

}
