package br.com.claudiasiqueira.powershell;

import java.io.IOException;

import br.com.claudiasiqueira.utils.PathUtils;

public class PowerShell {
	private String parameters = "";

	public void executar(String shellScript) throws IOException {
		String path = PathUtils.getResourcePath(shellScript);
		Process powerShellProcess = Runtime.getRuntime().exec("powershell " + path + " " + parameters);

	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
