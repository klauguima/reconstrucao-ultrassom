package br.com.claudiasiqueira.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.claudiasiqueira.model.Usuario;
import br.com.claudiasiqueira.server.TextToImagem;

public class ReconstrucaoController {

	private HttpServletRequest request;

	public ReconstrucaoController(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> reconstruir(String caminhoArquivoG) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		
		try {
			TextToImagem textToImagem = new TextToImagem();
			textToImagem.setCaminhoArquivoG(caminhoArquivoG);
		
			Calendar dtHoraInicio = Calendar.getInstance();
			String tempPathImage = File.createTempFile("image1", ".bmp").getAbsolutePath();
			
			Calendar dtHoraFim = Calendar.getInstance();

			textToImagem.setImagemDestino(tempPathImage);
			textToImagem.criaImagem();
			
			Usuario usuario = (Usuario) request.getSession(false).getAttribute("usuario");
			
			Map<String, Object> tamPixels = new HashMap<String, Object>();
			tamPixels.put("altura", 60);
			tamPixels.put("largura", 60);
			
			retorno.put("usuario", usuario);
			retorno.put("dtHoraInicio", dtHoraInicio);
			retorno.put("dtHoraFim", dtHoraFim);
			retorno.put("tamPixels", tamPixels);
			retorno.put("numIteracoes", textToImagem.getNumeroIteracoes());
			retorno.put("caminhoImagem", tempPathImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

}
