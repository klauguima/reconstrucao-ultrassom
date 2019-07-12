package br.com.claudiasiqueira.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.claudiasiqueira.model.Usuario;
import br.com.claudiasiqueira.powershell.PowerShell;
import br.com.claudiasiqueira.utils.OutputUtils;

public class ReconstrucaoController {

	private HttpServletRequest request;

	public ReconstrucaoController(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> reconstruir(String gFilePath) throws IOException {
		PowerShell powerShell = new PowerShell();
		Calendar dtHoraInicio = Calendar.getInstance();
		String tempPathImage = File.createTempFile("image1", ".bmp").getAbsolutePath();

		String parameters = "-outputImagePath " + tempPathImage;
		parameters += " -gFilePath " + gFilePath;
		parameters += " -hFilePath \"C:\\Users\\Klaus\\Desktop\\imagens\\H-1.txt\"";
		powerShell.setParameters(parameters);
		powerShell.executar("Reconstrucao.ps1");
		Calendar dtHoraFim = Calendar.getInstance();

		Usuario usuario = (Usuario) request.getSession(false).getAttribute("usuario");

		Map<String, Object> tamPixels = new HashMap<String, Object>();
		tamPixels.put("altura", 60);
		tamPixels.put("largura", 60);
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("usuario", usuario);
		retorno.put("dtHoraInicio", dtHoraInicio);
		retorno.put("dtHoraFim", dtHoraFim);
		retorno.put("tamPixels", tamPixels);
		retorno.put("numIteracoes", 15);
		retorno.put("caminhoImagem", tempPathImage);

		return retorno;
//		Identifica��o do usu�rio;
//		Data e hora do in�cio da reconstru��o;
//		Data e hora do t�rmino da reconstru��o;
//		Tamanho em pixels;
//		O n�mero de itera��es executadas.
	}
}
