package Array;

import java.util.Scanner;

public class LoopyMatrix {
	int loopyMatrix[][];
	int size;
	static int count = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter matrix size : ");
		LoopyMatrix loopyMatrix = new LoopyMatrix();
		int t;
		t = sc.nextInt();
		loopyMatrix.size = t;
		long start = System.currentTimeMillis();
		arrangeMatrix(loopyMatrix);
		printMatrix(loopyMatrix);
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start+" ms");
		sc.close();
	}
	private static void printMatrix(LoopyMatrix loopyMatrix) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, size = loopyMatrix.size;
		for(i = 0; i < size; i++) {
			System.out.println();
			for(j = 0; j<size; j++)
				System.out.print(loopyMatrix.loopyMatrix[i][j]+" ");
		}
		
	}
	private static void arrangeMatrix(LoopyMatrix loopyMatrix) {
		// TODO Auto-generated method stub
		int n = loopyMatrix.size;
		
		int i = 0;
		int j = 1;
		loopyMatrix.loopyMatrix = new int[n][n];
		loopyMatrix.loopyMatrix[0][0] = count++;
		
		goRight(loopyMatrix, i , j);
		
		
		
	}
	private static void goRight(LoopyMatrix loopyMatrix, int i, int j) {
		// TODO Auto-generated method stub
		if(j == loopyMatrix.size)return;
		if(loopyMatrix.loopyMatrix[i][j] != 0)return;
		loopyMatrix.loopyMatrix[i][j] = count++;
			goRight(loopyMatrix, i, j+1);
			goDown(loopyMatrix, i+1, j);
		
		
	}
	private static void goDown(LoopyMatrix loopyMatrix, int i, int j) {
		if(i == loopyMatrix.size)return;
		if(loopyMatrix.loopyMatrix[i][j] != 0)return;
		loopyMatrix.loopyMatrix[i][j] = count++;
			goDown(loopyMatrix, i+1, j);
			goLeft(loopyMatrix, i, j-1);
	}
	private static void goLeft(LoopyMatrix loopyMatrix, int i, int j) {
		if(j < 0)return;
		if(loopyMatrix.loopyMatrix[i][j] != 0)return;
		loopyMatrix.loopyMatrix[i][j] = count++;
			goLeft(loopyMatrix, i, j-1);
			goTop(loopyMatrix, i-1, j);
	}
	private static void goTop(LoopyMatrix loopyMatrix, int i, int j) {
		if(i < 0)return;
		if(loopyMatrix.loopyMatrix[i][j] != 0)return;
		loopyMatrix.loopyMatrix[i][j] = count++;
			goTop(loopyMatrix, i-1, j);
			goRight(loopyMatrix, i, j+1);
	}

}
