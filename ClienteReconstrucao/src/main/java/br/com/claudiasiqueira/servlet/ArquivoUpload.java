package br.com.claudiasiqueira.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import br.com.claudiasiqueira.controller.ReconstrucaoController;
import br.com.claudiasiqueira.utils.FileUtils;

@WebServlet("/reconstruir")
//@MultipartConfig
public class ArquivoUpload extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
//		final Part filePart = request.getPart("arquivo");
//		String caminhoArquivo = FileUtils.gravarArquivoTemporario(filePart);

//		Map<String, Object> retorno = new ReconstrucaoController(request).reconstruir(caminhoArquivo);
		Map<String, Object> retorno = new ReconstrucaoController(request).reconstruir("");
		writer.write(new Gson().toJson(retorno));
	}

}