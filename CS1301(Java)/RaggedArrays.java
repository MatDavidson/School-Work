public class RaggedArrays{
   public static void main (String [] args){
      //Declare a two-dimensional array of a known first dimension and unknown second dimension
      int [][] triangleArray = new int [5][];
      
      //Declare one dimensional array
      int [] t1 = {1, 11};
      int [] t2 = {2, 22, 202};
      int [] t3 = {33};
      int [] t4 = {44, 4, 400, 424};
      int [] t5 = {50, 500, 515, 525};
      
      //Assign the one-dimensional arrays to triangleArray[i]
      triangleArray [0] = t1;
      triangleArray [1] = t2;
      triangleArray [2] = t3;
      triangleArray [3] = t4;
      triangleArray [4] = t5;

      //traverse the two-dimensional array
      for (int i = 0; i < triangleArray.length; i++){
         System.out.println();
         for (int j = 0; j < triangleArray[i].length; j++)
            System.out.print (triangleArray[i][j] + "\t");
      }   
      
      //Using for each loop to display a two-dimensional array
      System.out.println();
      for (int [] t : triangleArray){
         System.out.println();
         for (int value : t)
            System.out.print (value + "\t");
      }
      
      //Declare a ragged array
      int[][] table = new int [4][];
      table[0] = new int [3];
      table[1] = new int [2];
      table[2] = new int [4];
      table[3] = new int [6];
      
      //populate array table
      for (int i = 0; i < table.length; i++){
         for (int j = 0; j < table[i].length; j++)
            table[i][j]= (int)(Math.random() * 10);
      }   

      //traverse the two-dimensional array
      for (int i = 0; i < table.length; i++){
         System.out.println();
         for (int j = 0; j < table[i].length; j++)
            System.out.print (table[i][j] + "\t");
      } 
      
   }
}