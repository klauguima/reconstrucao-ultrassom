package br.com.claudiasiqueira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.claudiasiqueira.controller.ReconstrucaoController;
import br.com.claudiasiqueira.utils.FileUtils;

@WebServlet("/reconstruir")
@MultipartConfig
public class ArquivoUpload extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final Part filePart = request.getPart("arquivo");
		String caminhoArquivo = FileUtils.gravarArquivoTemporario(filePart);

		new ReconstrucaoController(request).reconstruir(caminhoArquivo);
	}

}