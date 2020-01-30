#include<stdio.h>

void printarray(int *arrptr, int size){
  int i;
  for(i=0;i<size;i++){
    printf("%d\t", arrptr[i]);
  }
  printf("\n");
}


int main(){

  int a[5] = {1, 1, 1, 1, 1};
  int *p;
    
    /* 1. Indicate the output and explain (this one is done for you) */
    p = a;
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output: 1 1 1 1 1
    /* Explanation: It is same as the initial array, as 
    p is pointing to the first location of it. printing 
    of two addresses are same. */
    
   /* 2. Indicate the output and explain */
    *p = 3;
    /* Output: */
    /* Explain: */
    
    
    /* 3. Indicate the output and explain */
    *p++ = 5;
    /* Output: */
    /* Explain: */

    /* 4. Indicate the output and explain */
    *++p = 6;
    /* Output: */
    /* Explain: */

    
   /* 5. Indicate the output and explain */
    a[3] = (*p)++;
    /* Output: */
    /* Explain: */

   /* 6. Indicate the output and explain */
    p = &a[4];
    *p = *(p - 2);
    /* Output */
    /* Explain: */

    
    return 0;
}
