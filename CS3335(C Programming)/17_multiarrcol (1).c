/* Example demonstrating processing of columns of a 2D array. 
This is not as straightforward as procssing rows. */

#include<stdio.h>

#define ROW 3
#define COLUMN 4

int main(){
   
   int twoD[ROW][COLUMN] = {2, 3, 4, 5, 6, 7, 8, 9, 11, 16, 17, 19};
   
   int (*p)[COLUMN]; // pointer to an array of length COLUMN
   /* Parentheses are needed because *p[COLUMN] is an array of pointers. */

   int i;
   puts("Enter the column (0 - 3) that you want to make zero:");
   scanf("%d", &i);
   
   for(p=twoD; p < &twoD[ROW]; p++){ // p = twoD is basically p = &twoD[0]
      (*p)[i] = 0; // making column i as 0
   }
   
   int *pt = &twoD[0][0];

   puts("Elements of the array: ");

   for( ; pt < &twoD[ROW-1][COLUMN]; )
      printf("%d ", *pt++);

   printf("\n");
   return 0;
}
