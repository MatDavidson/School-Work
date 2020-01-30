/* Example demonstrating differene between 'array pointer' and 'pointer array' */

#include<stdio.h>

#define SIZE 5;

 int main(){

   int A[SIZE] = {3, 5, 6, 7, 8};
   int i; // loop controller variable

   int *pt1 = A; // pt1 is pointer to the 0th location of the array A

   printf("\n");
   printf("pt1 = %p\t Address of A = %p\t Address of A[0] = %p\n", pt1, A, &A[0]);
   printf("\n");
   /* Now, we can declare a pointer that points to an entire array rather 
      than a single specific location */

   int (*pt2)[SIZE]; // pt2 is a pointer to an array with SIZE number of integers

   /* Note, parenthesis is important to indicate pointer to an array because subscript
      has higher precedence than * (indirection) */

   pt2 = &A;
   printf("pt2 = %p\t Address of A = %p\n", pt2, A);
   printf("\n");

   /* This way of declaring the array pointer helps in double array manipulation. */

   /* Now we will declare an array bof pointers, a.k.a 'pointer array' */

   int *pt3[SIZE]; // this declares an array of length SIZE of 'int' type pointer variables

   // Note, there is no parenthesis around * and the pointer name

   for(i=0; i<SIZE; i++){
     pt3[i] = &A[i]; // stores pointers to these address locations in the array
   }

   //printing the addresses and corresponding values

   for(i=0; i<SIZE; i++){
     printf("Address of A[%d]: %p\t Value of A[%d]: %d\n", i, pt3[i], i, *pt3[i]);
   }
   printf("\n");
  return 0;
}
