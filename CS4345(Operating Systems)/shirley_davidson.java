package hw;

/*Emily Shirley, Mat Davidson
CS4345 - OS
Spring 2020
Assignment 2 */

import java.io.*;
import java.util.*;

public class shirley_davidson{
   public static void main(String[] args) throws java.io.IOException {
      //get file name through command line
      try{
         String filename = args[0];
         try {
        	 File file = new File(filename);         
        	 Scanner scan = new Scanner(file);
        	 //check if matrices are dot product compatible by reading first line
        	 String firstLine = scan.nextLine();
        	 String[] numArray = firstLine.split(" ");

        	 //compare the number of columns
        	 if(numArray[1].equals(numArray[3])){
        		 System.out.println("Generating Matrices...");  

        		 int rowA = Integer.parseInt(numArray[0]);
        		 int colA = Integer.parseInt(numArray[1]);
        		 int rowB = Integer.parseInt(numArray[2]);
        		 int colB = Integer.parseInt(numArray[3]);

        		 //skip empty line
        		 scan.nextLine();           

        		 //initialize matrices
        		 int[][] matrixA = new int[rowA][colA];
        		 int[][] matrixB = new int[rowB][colB];
        		 
        		 //matrix A
        		 System.out.println("Matrix A:");
        		 for(int r = 0; r < rowA; r++){
        			 for(int c = 0; c < colA; c++){
        				 matrixA[r][c] = scan.nextInt();
        				 System.out.print("\t" + matrixA[r][c]);
        			 }
        			 System.out.println();
        		 }

        		 //matrix B
        		 System.out.println("Matrix B:");
        		 for(int r = 0; r < rowB; r++){
        			 for(int c = 0; c < colB; c++){
        				 matrixB[r][c] = scan.nextInt();
        				 System.out.print("\t" + matrixB[r][c]);
        			 }
        			 System.out.println();
        		 }

        		 //The number of worker threads is the same as the number of cells 
        		 //in the product matrix. (rows = columns of first, columns = rows of second I think)

        		 //create space for product matrix as well as a placeholder for threads and a thread counter
        		 int[][] productMatrix = new int[colA][rowB]; 
        		 CalculateCell cc;
        		 int thread = 1;
        		 ArrayList<CalculateCell> ccs = new ArrayList<CalculateCell>();
        		 
        		 //create worker threads based on number of cells in product matrix
        		 for(int i = 0; i < colA; i++) {
        			 for(int j = 0; j < rowB; j++) {
        				 cc = new CalculateCell(thread, i, j, productMatrix, matrixA, matrixB);
        				 cc.start();
        				 ccs.add(cc);
        				 thread++;
        			 }
        		 }//end for
        		 
        		 //wait for all threads to finish
        		 for (CalculateCell c: ccs) {
        			 c.join();
        		 }
        		 
        		 //matrix P
        		 System.out.println("Product Matrix:");
        		 for(int i = 0; i<productMatrix.length;i++) {
        			 for(int j = 0; j < productMatrix[i].length; j++) {
        				 System.out.print("\t" + productMatrix[i][j]);
        			 }
        			 System.out.println();
        		 }
        		 
        	 }//end if(numArray[1].equals(numArray[3]))
        	 scan.close();
         }//end try (file not found)
         catch(Exception e) {
        	 System.out.print("File not found.");
         }
         
      }//end try (initialize filename)
      catch(Exception e) {
         System.out.print("No file name supplied.");
      }
   }//end main
}//end class

//Thread class that calculates the value of each cell in the product matrix
class CalculateCell extends Thread{
	int thread, row, col;
	int[][] matP, matA, matB;
	public CalculateCell(int thread, int row, int col, int[][] matP, int[][] matA, int[][] matB){ 
		this.thread = thread; this.row = row; this.col = col; this.matP = matP; this.matA = matA; this.matB = matB;}
	
	public void run(){
		System.out.println("Thread " + thread + " beginning calculations on P[" + row + "][" + col + "]");
	
		for(int i = 0; i < matA[0].length; i++) {
			matP[row][col] += matA[row][i]*matB[col][i];
		}
		System.out.println("Thread " + thread + " calculates P[" + row + "][" + col + "] to be " + matP[row][col]);
	}
}