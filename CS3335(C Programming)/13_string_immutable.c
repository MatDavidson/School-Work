/* Another example demonstrating issues of pointer and character arrays (string) */

#include<stdio.h>

int main(){
   /* The following code will encounter segmentation fault, because 'food' is 
   a pointer to a string literal (an immutable string in 'constant' section of 
   memory. This part of memory cannot be modified once created. */
   

   char *food = "mango";
   food[0] = 'M';
   printf("%s\n", food);
   
   
   /* Now comment line 11 - 13 and uncomment the following. 
   Compile and run the code and see the output */
   
   /*
   char str[] = "mango";
   char *food = str; // food is now pointer to a local variable which is in stack part of memory
   food[0] = 'M';
   printf("%s\n", food);
   */
   
   /* Now comment out line 20 - 23 again. Uncomment the previous segment, and write 
    the keyword 'const' in the declaration. It should look:  const char *food = "mango";
    Compile the code and see the result. There will be a compilation error notifying 
    about immutability of the string. This avoids the runtime error (segmentation fault). */ 
   
   return 0;
}
