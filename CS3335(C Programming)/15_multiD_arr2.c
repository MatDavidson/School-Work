/* Example demonstrating how a multidimentional array can be 
processed using pointer. The 2D array is stored as a sequential
structure. */

#include<stdio.h>

#define ROW 3
#define COLUMN 4

int main(){
   
   int twoD[ROW][COLUMN] = {2, 3, 4, 5, 6, 7, 8, 9, 11, 16, 17, 19};
   
   int *p;
   p = &twoD[0][0]; // a pointer pointing to the first location of the array
   
   puts("Elements of the array: ");
   for( ; p < &twoD[ROW-1][COLUMN]; ) // alt: p <= &twoD[ROW-1][COLUMN-1]
      printf("%d ", *p++); /* intentially made cryptic to demonstrate that 
      // for-loop controller can be altered outside the 'for( ; ; )' format */
   
   puts("\nProcessing of an individual row using pointer:-");
   
   printf("\nEnter a row-number between 0 and %d: ", ROW-1);
   
   int i;
   scanf("%d", &i);
     
   int *rp = twoD[i]; // a pointer pointing to ith row of the 2D array
   printf("Doubling the values in row-%d results in...\n", i);
   for( ; rp < twoD[i] + COLUMN; rp++)
      printf("%d ", *rp*2); 
      
     /* Note the use of * in two different ways in the above print statment -- 
     one as indirection operation and the second one as mutiplication operation.
     Also note the precedence of these two operations. */
   printf("\n\n");
   return 0;
}