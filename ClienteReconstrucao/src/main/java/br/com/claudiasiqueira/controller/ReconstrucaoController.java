package br.com.claudiasiqueira.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.claudiasiqueira.server.TextToImagem;

public class ReconstrucaoController {

	private HttpServletRequest request;

	public ReconstrucaoController(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> reconstruir(String caminhoArquivo) {
		try {
			TextToImagem textToImagem = new TextToImagem();
			textToImagem.criaImagem();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
