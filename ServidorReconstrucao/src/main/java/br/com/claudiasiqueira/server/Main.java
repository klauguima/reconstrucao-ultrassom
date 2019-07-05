package br.com.claudiasiqueira.server;

public class Main {
	
	public static void main(String[] args) {
		try {
			TextToImagem textToImagem = new TextToImagem();
			textToImagem.criaImagem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
