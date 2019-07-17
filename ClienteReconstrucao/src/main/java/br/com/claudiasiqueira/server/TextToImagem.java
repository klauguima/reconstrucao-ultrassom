package br.com.claudiasiqueira.server;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jblas.FloatMatrix;

public class TextToImagem {

	Integer rowsH = 50816;
	Integer colunsH = 3600;
	Integer rowsG = 50816;
	Integer colunsG = 1;
	
	private FloatMatrix hMatrix = new FloatMatrix(rowsH, colunsH);
	private FloatMatrix gMatrix = new FloatMatrix(rowsG, colunsG);

	private String caminhoArquivoG = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\g-1.txt";
	private String caminhoArquivoH = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\H-1.txt";
	private String imagemDestino = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\imagemResultado1.jpg";

	public void criaImagem() throws Exception {
		System.out.println("iniciou");
		readHFile();
		readGFile();
		FloatMatrix matrix = cgne();
		montaImagem(matrix);

		System.out.println("Conclu�do!");
	}

	private void readGFile() throws FileNotFoundException, IOException {
		BufferedReader bufferG = new BufferedReader(new FileReader(caminhoArquivoG));

		for (int j = 0; j < rowsG; j++) {
			String line = bufferG.readLine();
			gMatrix.put(j, 0, Float.parseFloat(line));
		}
		bufferG.close();
	}

	private void readHFile() throws FileNotFoundException, IOException {
		BufferedReader bufferH = new BufferedReader(new FileReader(caminhoArquivoH));
		System.out.println("Lendo arquivo H");
		for (int i = 0; i < rowsH; i++) {
			String line = bufferH.readLine();
			if (line != null && line != "") {
				String[] arrayLine = line.split(",");
				for (int j = 0; j < colunsH; j++) {
					gMatrix.put(i, j, Float.parseFloat(arrayLine[j]));
				}
			}
		}
		System.out.println("Terminou de ler o arquivo H");
		bufferH.close();
	}

	private FloatMatrix cgne() throws Exception {
		FloatMatrix fMatrix = FloatMatrix.zeros(colunsH, 1);
		
		/**
		 * Fórmula: r0 = g - Hf0
		 */
		FloatMatrix rMatrix = gMatrix;

		/**
		 * Fórmula: p0 = HTr0
		 */
		FloatMatrix pMatrix = hMatrix.transpose().mmul(rMatrix);

		Float alpha, beta;
		/**
		 * Fórmula: riT * ri
		 */
		Float rtXr = rMatrix.transpose().mmul(rMatrix).get(0, 0);

		Float ritXri;
		FloatMatrix ri;
		for (int i = 0; i < 5; i++) {
			alpha = rtXr / pMatrix.transpose().mmul(pMatrix).get(0, 0); // ai = riT * ri / piT * pi
			fMatrix = pMatrix.mmul(alpha).add(fMatrix);// fi+1 = fi + ai * pi
			ri = hMatrix.mmul(pMatrix).mmul(alpha).rsub(rMatrix);// ri+1 = ri - ai * H * pi
			ritXri = ri.transpose().mmul(ri).get(0, 0);// =ri+1T * ri+1
			beta = ritXri / rtXr;// Bi = ri+1T * ri+1 / riT * ri
			pMatrix = hMatrix.transpose().mmul(ri).add(pMatrix.mmul(beta));// pi = HT * ri+1 + Bi * pi
			rMatrix = ri;// ri = ri+1
			rtXr = ritXri;
		}
		return fMatrix;
	}

	private void montaImagem(FloatMatrix matrix) throws IOException {
//		Float max = matrix[0][0];
//		Float min = matrix[0][0];
//		for (int i = 0; i < height; i++) {
//			if (matrix[i][0] > max) {
//				max = matrix[i][0];
//			}
//			if (matrix[i][0] < min) {
//				min = matrix[i][0];
//			}
//		}
//
//		BufferedImage theImage = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
//		int k = 0;
//		for (int i = 0; i < 60; i++) {
//			for (int j = 0; j < 60; j++) {
//				int value = (int) ((255 / (max - min)) * (matrix[k][0] - min));
//				theImage.setRGB(i, j, value);
//				k++;
//			}
//		}
//		File outputfile = new File(imagemDestino);
//		ImageIO.write(theImage, "jpg", outputfile);
	}
}
