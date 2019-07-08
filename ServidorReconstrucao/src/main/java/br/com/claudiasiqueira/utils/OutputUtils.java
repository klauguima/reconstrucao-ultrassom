package br.com.claudiasiqueira.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class OutputUtils {

	private HttpServletResponse response;

	public OutputUtils(HttpServletResponse response) {
		this.response = response;
	}

	public void writeOutputFile(String tempPathImage) throws IOException {
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(tempPathImage);
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0){
		    out.write(buffer, 0, length);
		}
		in.close();
		out.flush();
	}

}
