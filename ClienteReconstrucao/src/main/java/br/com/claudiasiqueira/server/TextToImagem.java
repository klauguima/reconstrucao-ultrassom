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

import br.com.claudiasiqueira.matrix.MatrixUtil;

public class TextToImagem {

	public static void main(String[] args) {
		try {
			TextToImagem textToImagem = new TextToImagem();
			textToImagem.criaImagem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Integer width = 50816;
	Integer height = 3600;
	Integer width = 1000;
	
	private Float[][] hMatrix = new Float[width][height];
	private Float[][] gMatrix = new Float[width][1];

	private String caminhoArquivoG = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\g-1.txt";
	private String caminhoArquivoH = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\H-1.txt";
	private String imagemDestino = "C:\\Users\\Kleber\\Documents\\projetos\\claudia-faculdade\\Imagem\\imagemResultado1.jpg";

	public void criaImagem() throws Exception {
		System.out.println("iniciou");
		readHFile();
		readGFile();
		Float[][] matrix = cgne();
		montaImagem(matrix);

		System.out.println("Concluído!");
	}

	private void readGFile() throws FileNotFoundException, IOException {
		BufferedReader bufferG = new BufferedReader(new FileReader(caminhoArquivoG));
		String lineG = "";

		for (int j = 0; j < width; j++) {
			String line = bufferG.readLine();
			gMatrix[j][0] = Float.parseFloat(line);
		}
		bufferG.close();
	}

	private void readHFile() throws FileNotFoundException, IOException {
		BufferedReader bufferH = new BufferedReader(new FileReader(caminhoArquivoH));
		for (int i = 0; i < width; i++) {
			String line = bufferH.readLine();
			if (line != null && line != "") {
				String[] arrayLine = line.split(",");
				for (int j = 0; j < height; j++) {
					hMatrix[i][j] = Float.parseFloat(arrayLine[j]);
				}
			}
//			System.out.println(i);
		}
		bufferH.close();
	}

	private Float[][] cgne() throws Exception {
		Float[][] fMatrix = new Float[height][1];
		for (int i = 0; i < height; i++) {
			fMatrix[i][0] = 0.0f;
		}

		/**
		 * Fórmula: r0 = g - Hf0
		 */
		Float[][] resultMatrix = MatrixUtil.subtract(gMatrix, MatrixUtil.multiply(hMatrix, fMatrix));

		/**
		 * Fórmula: p0 = HTr0
		 */
		Float[][] pMatrix = MatrixUtil.matrixMultTranpose(hMatrix, resultMatrix);

		Float alpha, beta;
		/**
		 * Fórmula: riT * ri
		 */
		Float rtXr = (MatrixUtil.multiply(MatrixUtil.transpose(resultMatrix), resultMatrix))[0][0];
		Float ritXri;
		Float[][] ri;
//        for(int i = 0; i < 15; i++) {
		for (int i = 0; i < 5; i++) {
			alpha = rtXr / (MatrixUtil.multiply(MatrixUtil.transpose(pMatrix), pMatrix))[0][0];// ai = riT * ri / piT * pi
			fMatrix = MatrixUtil.sum(fMatrix, MatrixUtil.multiply(pMatrix, alpha));// fi+1 = fi + ai * pi
			ri = MatrixUtil.subtract(resultMatrix, MatrixUtil.multiply(MatrixUtil.multiply(hMatrix, pMatrix), alpha));// ri+1 = ri - ai * H * pi
			ritXri = (MatrixUtil.multiply(MatrixUtil.transpose(ri), ri))[0][0];// =ri+1T * ri+1
			beta = ritXri / rtXr;// Bi = ri+1T * ri+1 / riT * ri
			pMatrix = MatrixUtil.sum(MatrixUtil.matrixMultTranpose(hMatrix, ri), MatrixUtil.multiply(pMatrix, beta));// pi = HT * ri+1 + Bi * pi
			resultMatrix = ri;// ri = ri+1
			rtXr = ritXri;
		}
		return fMatrix;
	}

	private void montaImagem(Float[][] matrix) throws IOException {
		Float max = matrix[0][0];
		Float min = matrix[0][0];
		for (int i = 0; i < height; i++) {
			if (matrix[i][0] > max) {
				max = matrix[i][0];
			}
			if (matrix[i][0] < min) {
				min = matrix[i][0];
			}
		}

		BufferedImage theImage = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
		int k = 0;
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 60; j++) {
				int value = (int) ((255 / (max - min)) * (matrix[k][0] - min));
				theImage.setRGB(i, j, value);
				k++;
			}
		}
		File outputfile = new File(imagemDestino);
		ImageIO.write(theImage, "jpg", outputfile);
	}
}
