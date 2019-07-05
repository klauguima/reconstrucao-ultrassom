package br.com.claudiasiqueira.matrix;

import java.util.Scanner;

public class MatrixUtil {

	public static Float[][] multiply(Float[][] matrix, Float scalarValue) throws Exception {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = matrix[i][j] * scalarValue;
			}
		}
		return matrix;
	}
	
	public static Float[][] multiply(Float[][] matrixA, Float[][] matrixB) throws Exception {
		int numRowsA, numColumnsA, numRowsB, numColumnsB, c, d, k;
		float sum = 0.0f;

		numColumnsA = matrixA[0].length;
		numRowsA = matrixA.length;

		numColumnsB = matrixB[0].length;
		numRowsB = matrixB.length;

		if (numColumnsA != numRowsB) {
			throw new Exception("As matrixes não podem ser multiplicadas");
		} else {
			Float matrixResult[][] = new Float[numRowsA][numColumnsB];

			for (c = 0; c < numRowsA; c++) {
				for (d = 0; d < numColumnsB; d++) {
					for (k = 0; k < numRowsB; k++) {
						sum = sum + matrixA[c][k] * matrixB[k][d];
					}

					matrixResult[c][d] = sum;
					sum = 0;
				}
			}
			return matrixResult;
		}
	}

	public static Float[][] subtract(Float[][] matrixA, Float[][] matrixB) {
		int numRowsA, numColumnsA, numRowsB, numColumnsB;

		numColumnsA = matrixA[0].length;
		numRowsA = matrixA.length;

		numColumnsB = matrixB[0].length;
		numRowsB = matrixB.length;

		Float matrixResult[][] = new Float[numRowsA][numColumnsB];
		for (int i = 0; i < numRowsA; i++) {
			for (int j = 0; j < numColumnsA; j++) {
				if (matrixB.length > i && matrixB[i].length > j) {
					matrixResult[i][j] = matrixA[i][j] - matrixB[i][j];
				} else {
					matrixResult[i][j] = matrixA[i][j];
				}
			}
		}

		return matrixResult;
	}

	public static Float[][] sum(Float[][] matrixA, Float[][] matrixB) {
		int numRowsA, numColumnsA, numRowsB, numColumnsB;

		numColumnsA = matrixA[0].length;
		numRowsA = matrixA.length;

		numColumnsB = matrixB[0].length;
		numRowsB = matrixB.length;

		Float matrixResult[][] = new Float[numRowsA][numColumnsB];
		for (int i = 0; i < numRowsA; i++) {
			for (int j = 0; j < numColumnsA; j++) {
				if (matrixB.length > i && matrixB[i].length > j) {
					matrixResult[i][j] = matrixA[i][j] + matrixB[i][j];
				} else {
					matrixResult[i][j] = matrixA[i][j];
				}
			}
		}

		return matrixResult;
	}

	public static Float[][] matrixMultTranpose(Float[][] matrixA, Float[][] matrixB) {
		int m, row, numRowsB, col;

		row = matrixA[0].length;
		col = matrixB[0].length;

		m = matrixA.length;

		Float matrixResult[][] = new Float[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				float sum = 0.0f;
				for (int k = 0; k < m; k++) {
					sum += matrixA[k][i] * matrixB[k][j];
				}
				matrixResult[i][j] = sum;
			}
		}

		return matrixResult;
	}

	public static Float[][] transpose(Float[][] matrix) {
		Float transpose[][] = new Float[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}

		return transpose;
	}
}