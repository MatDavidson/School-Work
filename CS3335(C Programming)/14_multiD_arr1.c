/* Example demonstrates how multi-dimentional arrays are initialized */
/* The braces { } make difference. Try both initilaizations (one at a time)
 and check the effect. */

#include<stdio.h>

int main(){
   int arr[3][4]= {{1, 2, 3, 4, 5} , {11, 16, 17}, {3, 6, 7, 8}}; /* initialization-1 */
   //int arr[3][4]= {1, 2, 3, 4, 5 , 11, 16, 17, 3, 6, 7, 8};  /* initialization-2 */
   
   int a, b;
   for(a = 0; a<3; a++){
      for(b=0; b<4; b++){
         printf("%d\t", arr[a][b]);
      }
      printf("\n");
   }
   return 0;
}