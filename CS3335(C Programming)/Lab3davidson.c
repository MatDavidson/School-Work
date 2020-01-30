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
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output: 3 1 1 1 1*/
    /* Explain: The assignment changes the content found at the address of p*/
    
    
    /* 3. Indicate the output and explain */
    *p++ = 5;
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output: 5 1 1 1 1*/
    /* Explain: The assignment is completed before the increment occurs, so a[0] is set to 5 
                while the pointer now points to a[1]*/

    /* 4. Indicate the output and explain */
    *++p = 6;
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output: 5 1 6 1 1*/
    /* Explain: In part 3, *p is set to point to a[1] after the assignment. Here, the pointer 
                is preincremented changing the adress it points to to the address of a[2].
                The value stored there is then assigned a value of 5. */

    
   /* 5. Indicate the output and explain */
    a[3] = (*p)++;
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output: 5 1 7 6 1*/
    /* Explain: Here, a[3] is being directly assigned the value located where the pointer is 
                pointing (a[2]). The value held in a[2] is then incremented*/

   /* 6. Indicate the output and explain */
    p = &a[4];
    *p = *(p - 2);
    printarray(a, 5);
    printf("p = %p\t a = %p\n", p, a);
    /* Output 5 1 7 6 7*/
    /* Explain: p is set to hold the address of a[4]. That location is then assigned the value
                held at a[2]. The enclosed operation p-2, tells the pointer to check the address 
                2 slots down*/

    
    return 0;
}
