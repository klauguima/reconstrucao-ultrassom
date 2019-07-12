package br.com.claudiasiqueira.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class FileUtils {

	public static String gravarArquivoTemporario(final Part filePart) throws IOException {
		OutputStream out = null;
		InputStream filecontent = null;

		try {
			File temporario = File.createTempFile("arquivo", ".txt");
			out = new FileOutputStream(temporario);
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			return temporario.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
		return null;
	}

}
