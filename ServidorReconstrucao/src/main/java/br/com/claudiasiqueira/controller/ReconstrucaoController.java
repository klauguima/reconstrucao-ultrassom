package br.com.claudiasiqueira.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.com.claudiasiqueira.powershell.PowerShell;
import br.com.claudiasiqueira.utils.OutputUtils;

public class ReconstrucaoController {

	private HttpServletResponse response;

	public ReconstrucaoController(HttpServletResponse resp) {
		this.response = resp;
	}

	public void reconstruir(String hFilePath) throws IOException {
		PowerShell powerShell = new PowerShell();

	    String tempPathImage = File.createTempFile("image1", ".bmp").getAbsolutePath();

		powerShell.setParameters("-outputImagePath " + tempPathImage);
		powerShell.executar("Reconstrucao.ps1");
		
		new OutputUtils(this.response).writeOutputFile(tempPathImage);
	}

}
