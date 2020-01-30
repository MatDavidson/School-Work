/* Example illustrates how strings are stored as character array internally.
The last cell is with a special non-printable delimiter '\O' as end. */

#include<stdio.h>
#include<string.h>

int main(){
	char ch = "abcd"[4]; //strings are arrays internally
	printf("%c\n", ch); // try running this code by changing the index to 3
	
   puts("\nMore on strings as character arrays..");
   
   char greet[6] = "Hello";
   char greet1[5] = "Chiao"; 
   // after running this, swap line positions of greet and greet1 to observe the change in output
   char greet2[6] = "Bonjour"; // the string literal gets truncated for not having enough space
   char greet3[] = "Bonjour"; // this is open ended array

   printf("\n");
   
   // observe how the last and first memory locations overlap; in fact, it gets overwritten
   printf(greet1);
   printf("\nFirst address of greet = %p\t Last address of greet = %p\n", &greet[0], &greet[6]);
   printf("\nFirst address of greet1 = %p\t Last address of greet1 = %p\n\n", &greet1[0], &greet1[5]);
   printf("Greet1: last char = %c\t", *(&greet1[5]));
   
   printf("\nDone!\n");
   return 0;
}