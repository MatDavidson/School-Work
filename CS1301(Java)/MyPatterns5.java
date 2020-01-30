//****************************************************************************
//Purpose:	Using loops to display patterns    
//Author:	Mathieu Davidson
//Class:		CS1301A
//Date:		9/24/2017
//Program:	MyPatterns5.java
//****************************************************************************
public class MyPatterns5 {
	public MyPatterns5() {
	}
	
   //pattern I was already implemented
	public void displayPatternI(int lines) {
			System.out.println("\n\tPattern I\n");
			for (int i = 1; i <= lines; i++){
				for (int j = 1; j <= i; j++){
					System.out.print (j + " " );
            }
			   System.out.println();
		   }
	}//end displayPatternI
 
   //open displayPatternII
 	public void displayPatternII (int lines) {
  		System.out.println("\n\tPattern II\n");
      
      //open a for loop, initialize i to the value of lines, continue until i is 1, decrement i
      for (int i = lines; i >= 1; i--){
      
         // open an inner for loop, initialize j to the value of i, continue until j is 1, decrement j   
			for (int j = i; j >= 1; j--){
         
            //print the value of j and a space according to the loop conditons
				System.out.print (j + " " );
         }
         //move the cursor to the next line
		   System.out.println();
      }

	}//end displayPatternII

  
  
   //open displayPatternIII
 	public void displayPatternIII (int lines) {
  		System.out.println("\n\tPattern III\n");
      
      //declare the variables needed in the loops
      int i, j, k, m, n;
      
      //open a for loop, assign the value of lines to i and 0 to j, continue until i is 1, 
      //decrement i and incremnt j
      for (i = lines, j = 0; i >= 1; i--, j++){
         
         //assign values to my other variables to keep their values consistent with the variables in
         // the outer loop, but they can be manipulated within the for loop without interfering with
         // the control values of the outer loop
         k = j; // k is assigned the value of j
         m = lines; 
         n = lines; //m and n are both assigned the value of lines
         
         //open a while loop, continue until k is 1
         while (k >= 1){
         
            //since k is eqaul to j and j increments once for every iteration of the outer for loop,
            // this while loop will print a blank space for every iteration of the outer loop after
            // the first iteration. after it prints each blank space, it decrements k and m until k is 1
            System.out.print("  ");
            k--;
            m--;
         }//end of the first inner while loop
         
         //open a second while loop, continue until m is 1   
         while (m >= 1){
         
            //since m is equal to lines minus the number of iterations of the first inner while loop, 
            // this loop will print the value of n (which is also the value of lines) and a space. It
            // then decrements n and m.
            System.out.print(n + " " );
            n--;
            m--;
         }//end of second inner while loop
         
         //move the cursor to the next line
         System.out.println();

      }//end of outer loop                  
	}//end displayPatternIII

  
  
   //open displayPatternIV
	public void displayPatternIV (int lines) {
  		System.out.println("\n\tPattern IV\n");
      
      //declare variables to be used in the loops
      int i, j, k, m, n;
      
      //open a for loop. initialize i to one and j to the value of lines; continue until i equals 
      // lines; increment i and decrement j
      for (i = 1, j = lines - 1; i <= lines; i++, j--){
      
         //assign values to my other variables to keep their values consistent with the variables in
         // the outer loop, but they can be manipulated within the for loop without interfering with
         // the control values of the outer loop
         k = j;
         m = lines;
         n = lines;
         
         //open a while loop that will print blank spaces leadiing in to a count down. after each 
         // iteration, it will decrement the vaule of m which affects the next loop
         while (k >= 1){
            System.out.print("  ");
            k--;
            m--;
         }//end of blank space loop
         
         //open a while loop that will print the value of n and count down from n until the the cursor
         // reaches the last "collum". the last space of the line is controlled by the value of m,
         // which is larger in each iteration of the outer loop 
         while (m >= 1){
            System.out.print(n + " " );
            m--;
            n--;
         }//end of the countdown loop
         
         //move the cursor to the next line
         System.out.println();
      }//end of outer loop         
      
	}//end displayPatternIV

  
  
   //open displayPatternV
	public void displayPatternV (int lines) {
  		System.out.println("\n\tPattern V\n");
      
      //declare variables to be used in the loops 
      int i, j, k, m, n, o;
      
      //open the outer for loop, initialize i to one, j to 0 and k to the value of lines; continue 
      // until i is eqaul to lines; increment i and j, decrement k
      for (i = 1, j = 0, k = lines; i <= lines; i++, j++, k--){
      
         //assign values to my other variables to keep their values consistent with the variables in
         // the outer loop, but they can be manipulated within the for loop without interfering with
         // the control values of the outer loop
         m = j;
         n = k;
         
         //open an inner while loop that will print blank spaces leading in to the numbers counting down
         while (m >=1){
            System.out.print("  ");
            m--;            
         }//end of blank space lead in loop
         
         //open an inner while loop that will countdown from the value of n to 1
         while (n >= 1){
            System.out.print(n + " " );
            n--;
         }// of count down loop
         
         //since n is decremented after each iteration of the countdown loop, its value starts as 0 in
         // the next loop. this would cause the output to print two 1s in a row. to fix this we increment
         // the value of n
         n++;
         
         //open a while loop that will print a count up from 1 to the value of k
         while (n < k){
            n++;
            System.out.print(n + " " );
         }//end of count up loop
         
         //move the cursor to the next line
         System.out.println();
      }//end of outer for loop              
	}//end displayPatternV

  
  
   //open displayPatternVI, i decided to mak a v pattern as my own design
	public void displayPatternVI (int lines) {
  		System.out.println("\n\tMy Own Pattern\n");
      
      //declare the varibles for my loops
      int i, j, k, m, n, o;
      
      //open the outer for loop. initialize i to 0 and k to the value of lines; continue until i eqauls
      // lines; increment i and reduce the value of k by 2
      for (i = 0, k = lines; i <= lines; i++, k-=2){
         
         //this inner loop handles the blank spaces that lead in to the v.  
         j = i;
         while (j >= 1){
            System.out.print("  ");
            j--;
         }
         
         //this section handles the count up from 1 to the value of lines. start by assigning values to variables
         m = 1;
         n = lines;
         
         //this if statement alters the highest diget counted to (the middle digit) if the number of blank spaces 
         // in the middle of the v is 0
         if (k < 0){
            n = n + (int)(k/2);
         }
         
         //open a do-while loop to print the value of m and a space. it then increments m and checks to see if m
         // is less than or equal to n. n will have the same value of lines until there are no blank spaces 
         // between the count up and count down
         do{
            System.out.print( m + " ");
            m++;
         }while (m <= n);
         
         //m must be decremented to prevent the count down from starting one digit too high
         m--;
         
         
         //this section will print the blank spaces in the middle of the v pattern. 
         o = k;
         while (o >= 1){
            System.out.print("  ");
            o--;
         }
         
         //this section will handle the countdown. the if statemnt at the top checks if the value of
         // lines is odd and if the value of k is less than 0. this makes it so that whether the value
         // of lines is odd or even, the pattern still prints evenly. if the number is even, the value
         // that is being counted up to will be printed twice to keep the spacing correct
         if ( lines % 2 != 0 && k < 0){
            m--;
         }
         
         //this is the loop that prints the countdown
         while (m >= 1){
            System.out.print( m + " ");
            m--;
         }
         System.out.println();
      }                      
	}//end displayPatternVI

}