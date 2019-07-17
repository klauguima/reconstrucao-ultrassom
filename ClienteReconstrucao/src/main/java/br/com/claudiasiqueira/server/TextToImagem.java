package br.com.claudiasiqueira.server;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jblas.FloatMatrix;

public class TextToImagem {

	private static Integer rowsH = 50816;
	private static Integer columnsH = 3600;
	Integer rowsG = 50816;
	Integer columnsG = 1;
	
	private static FloatMatrix hMatrix = null;
	private FloatMatrix gMatrix = new FloatMatrix(rowsG, columnsG);

	private String caminhoArquivoG = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\g-2.txt";
	private String caminhoArquivoH = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\H-1.txt";
	private String imagemDestino = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\imagemResultado3.jpg";
	private int numeroIteracoes = 0;

	public void criaImagem() throws Exception {
		System.out.println("iniciou");
		readHFile();
		readGFile();
		FloatMatrix matrix = cgne();
		montaImagem(matrix);

		System.out.println("Concluído!");
	}

	private void readGFile() throws FileNotFoundException, IOException {
		BufferedReader bufferG = new BufferedReader(new FileReader(getCaminhoArquivoG()));

		for (int j = 0; j < rowsG; j++) {
			String line = bufferG.readLine();
			gMatrix.put(j, 0, Float.parseFloat(line));
		}
		bufferG.close();
	}

	private void readHFile() throws FileNotFoundException, IOException {
		if(hMatrix != null) {
			System.out.println("Obteve arquivo H da memória");
			return;
		}
		TextToImagem.hMatrix = new FloatMatrix(TextToImagem.rowsH, TextToImagem.columnsH);
				
		BufferedReader bufferH = new BufferedReader(new FileReader(caminhoArquivoH));
		System.out.println("Lendo arquivo H");
		for (int i = 0; i < rowsH; i++) {
			String line = bufferH.readLine();
			if (line != null && line != "") {
				String[] arrayLine = line.split(",");
				for (int j = 0; j < columnsH; j++) {
					hMatrix.put(i, j, Float.parseFloat(arrayLine[j]));
				}
			}
		}
		System.out.println("Terminou de ler o arquivo H");
		bufferH.close();
	}

	private FloatMatrix cgne() throws Exception {
		FloatMatrix fMatrix = FloatMatrix.zeros(columnsH, 1);

		FloatMatrix hMatrixTransp = hMatrix.transpose();
		
		/**
		 * Fórmula: r0 = g - Hf0
		 */
//		FloatMatrix rMatrix = gMatrix;
		FloatMatrix rMatrix = hMatrix.mmul(fMatrix).rsub(gMatrix);
		
		/**
		 * Fórmula: p0 = HTr0
		 */
		FloatMatrix pMatrix = hMatrixTransp.mmul(rMatrix);

		Float alpha, beta;
		/**
		 * Fórmula: riT * ri
		 */
		Float rtXr = rMatrix.transpose().mmul(rMatrix).get(0, 0);

		Float ritXri;
		FloatMatrix ri;
		for (int i = 0; i < 15; i++) {
			alpha = rtXr / pMatrix.transpose().mmul(pMatrix).get(0, 0); // ai = riT * ri / piT * pi
			fMatrix = pMatrix.mmul(alpha).add(fMatrix);// fi+1 = fi + ai * pi
			ri = hMatrix.mmul(pMatrix).mmul(alpha).rsub(rMatrix);// ri+1 = ri - ai * H * pi
			ritXri = ri.transpose().mmul(ri).get(0, 0);// =ri+1T * ri+1
			beta = ritXri / rtXr;// Bi = ri+1T * ri+1 / riT * ri
			pMatrix = hMatrixTransp.mmul(ri).add(pMatrix.mmul(beta));// pi = HT * ri+1 + Bi * pi
			rMatrix = ri;// ri = ri+1
			rtXr = ritXri;

//			float norm2 = rMatrix.norm2();
			numeroIteracoes++;
		}
		return fMatrix;
	}

	private void montaImagem(FloatMatrix matrix) throws IOException {
		Float max = matrix.get(0, 0);
		Float min = matrix.get(0, 0);
		for (int i = 0; i < columnsH; i++) {
			float currentValue = matrix.get(i, 0);
			if (currentValue > max) {
				max = currentValue;
			}
			if (currentValue < min) {
				min = currentValue;
			}
		}

		BufferedImage theImage = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
		int k = 0;
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 60; j++) {
				int value = (int) ((255 / (max - min)) * (matrix.get(k, 0) - min));
				theImage.setRGB(i, j, new Color(value, value, value).getRGB());
				k++;
			}
		}
		File outputfile = new File(getImagemDestino());
		ImageIO.write(theImage, "jpg", outputfile);
	}

	public String getCaminhoArquivoG() {
		return caminhoArquivoG;
	}

	public void setCaminhoArquivoG(String caminhoArquivoG) {
		this.caminhoArquivoG = caminhoArquivoG;
	}

	public String getImagemDestino() {
		return imagemDestino;
	}

	public void setImagemDestino(String imagemDestino) {
		this.imagemDestino = imagemDestino;
	}

	public int getNumeroIteracoes() {
		return numeroIteracoes;
	}

}
