package br.com.claudiasiqueira.powershell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.claudiasiqueira.utils.PathUtils;

public class PowerShell {
	private String parameters = "";

	public void executar(String shellScript) throws IOException {
		String path = PathUtils.getResourcePath(shellScript);
		Process powerShellProcess = Runtime.getRuntime().exec("powershell " + path + " " + parameters);
		// Getting the results
		powerShellProcess.getOutputStream().close();
		String line;
		System.out.println("Standard Output:");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			System.out.println(line);
		}
		stdout.close();
		System.out.println("Standard Error:");
		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			System.out.println(line);
		}
		stderr.close();
		System.out.println("Done");
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
