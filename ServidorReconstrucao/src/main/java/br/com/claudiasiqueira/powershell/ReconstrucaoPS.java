package br.com.claudiasiqueira.powershell;

import java.io.IOException;

public class ReconstrucaoPS {
	public static void main(String[] args) {
		try {
			ReconstrucaoPS reconstrucaoPS = new ReconstrucaoPS();
			reconstrucaoPS.reconstruirImagem();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reconstruirImagem() throws IOException {
		PowerShell powerShell = new PowerShell();
		powerShell.executar("CriacaoImagem.ps1");
	}
}
