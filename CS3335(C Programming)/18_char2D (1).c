/* Example shows use of pointer arrays in handling 2D character array */

#include<stdio.h>

/* In this example we will use 4 names (strings). As we have seen before, 
   each name (string) is a character array. */

#define SIZE 4;

int main(){
  /* declare an array of 4 pointers, each pointing to a 
     string (an array of characters) */

  char *ptrs[SIZE] = {"Joye", "David", "Kim", "Elizabeth"};

  int i;
  for(i=0; i<SIZE; i++){
    printf("\n Address of ptrs[%d] = %p\t Value: %s\n", i, &ptrs[i], *(&ptrs[i]));

    /* for the last item we could simply use ptrs[i] to display the 
       string instead of using the * (the indirection operator) */
  }

  /* Now, suppose we want to display the character at index 2 of the string at index 1 */

  printf("\n Displaying a specific character.. say, char at 2 in string at 1\n\n");

  printf(" ptrs[1][2] = %c\n", ptrs[1][2]);
  
  printf(" Alternative expression: *(ptrs[1] + 2) = %c\n", *(ptrs[1] + 2));

  printf(" Another alternative: *(*(ptrs + 1) + 2) = %c\n", *(*(ptrs + 1) + 2));

  printf("\n");
  return 0;
}
