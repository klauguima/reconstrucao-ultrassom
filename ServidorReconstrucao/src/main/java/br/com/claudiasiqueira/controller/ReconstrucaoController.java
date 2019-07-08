package br.com.claudiasiqueira.controller;

import java.io.IOException;

import br.com.claudiasiqueira.powershell.PowerShell;

public class ReconstrucaoController {

	public void reconstruir(String hFilePath) throws IOException {
		PowerShell powerShell = new PowerShell();
//		powerShell.setParameters("");
		powerShell.executar("Reconstrucao.ps1");
	}

}

