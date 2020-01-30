/* Example shows how array and pointers are related */

#include<stdio.h>

int main(){
   int arr[3] = {3, 6, 8}; // arr is a pointing to a physical array on memory
   
   int *pt; // pt is a pointer to an integer type variable
   
   pt = arr; // pt now points to arr (basically the first location of arr)
   
   printf("%d\n", pt[1]); // using pt, you can access the array
   
   puts("Printing of addresses...");
   
   printf("pt = %p, arr = %p, address of first element (arr[0]) = %p\n", pt, arr, &arr[0]); 
   
   puts("Do they all address the same location?");
   
   return 0;
}