import java.util.Scanner;

public class MyClass {
	
	
	public static void main(String[] args) {
		

		
		MyClass c = new MyClass();
		Scanner Keyboard = new Scanner(System.in);
		
		int[][] matrix1 = new int[4][4];
		int[][] matrix2 = new int[4][4];
		int[][] matrix3 = new int[4][4];
		
		int sum = 0;
	
		
		//creating first matrix
		System.out.println("Enter values of either 0 or 1 for matrix 1: ");
		
		
		for(int y = 0; y < matrix1[0].length; y++) {
			
			for(int x = 0; x < matrix1.length; x++) {
				

				matrix1[y][x] = Keyboard.nextInt();
				
			}	
			
		}
		
		System.out.println("printing matrix 1: ");
		c.printMatrix(matrix1);
		System.out.println();
		
		
		//creating second matrix
	System.out.println("Enter values of either 0 or 1 for matrix 2: ");
		
		
		for(int y = 0; y < matrix2[0].length; y++) {
			
			for(int x = 0; x < matrix2.length; x++) {
				

				matrix2[y][x] = Keyboard.nextInt();
				
			}	
			
		}
		
		System.out.println("printing matrix 2: ");
		System.out.println();
		c.printMatrix(matrix2);
		System.out.println();
		
		
		
		//now multiply the two matrix together
		System.out.println("Product of matrix 1 and matrix 2: ");
		System.out.println();
		matrix3 = multiplyMatrices(matrix1, matrix2);
		c.printMatrix(matrix3);
		System.out.println();
		
		//get connections 
		
		for(int i = 0; i < matrix3.length; i++) {
			for(int k = 0; k < matrix3.length; k++)
			sum+= matrix3[i][k];
		}
		System.out.println("Connections: " + sum);
	}
		

	 public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
		 int[][] matrix3 = new int[4][4];
	        for(int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                for (int k = 0; k < 4; k++) {
	                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
	                }
	            }
	        }
	        return matrix3;
	    }
	
	public void printMatrix(int[][] matrix) {
		
		for(int y = 0; y < matrix[0].length; y++) {
			
			for(int x = 0; x < matrix.length; x++) {
				
				
				System.out.print(matrix[y][x]);
			
			}	
			System.out.println(" ");
		}
	
	}

}
