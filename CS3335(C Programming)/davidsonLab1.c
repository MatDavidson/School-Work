/* Mat Davidson */

#include<stdio.h>

int main(){
   int arr[4] = {3, 6, 7, 8}; 
   
   int *pt; 

   /* uncomment the following two lines, followed by compilation and execution. What do you get? */
   
   //puts("Value at address pointed by pt:\t");
   
   //printf("%d\n", *pt);

   /* Why did you get the result? Write your conclusion here:
        Segmentation fault. The pointer has not been given an address yet.
   
   
    */

   /* After you observe the result and wrote your conclusion, comment out lines 12 and 14 back. */

   /****************************************/

/* After you are done testing the previous segment, uncomment lines 28 - 34, compile and execute. */
 
   pt = arr; 
   
   printf("Output 1: %d\n", *pt);
   
   puts("Value at arr:\t");  

  // printf("Output 2: %d\n", arr); 

   /* What are the values you get? Explain why you got them. */

   /* Write your response here: 
        Output 1: 3
        Output 2: -1612814992
   
        The print line for output 2 tells the system to print the array as an
        integer value. Running the code again gives different values for output 2
        so I assume that the nummber is an integer representation of the memory
        address. 
   */

   /* After you are done writing your explanation for output1 and output2, comment out 
   line 34 only and uncomment the line below (line 48). Then compile again and execute. */
   
   printf("Output 3: %d\n", *arr);

   /* What value you get as output3? Explain why you got it. */
   
   /* Write your response here:
        Output 3: 3
   
        This is the same as output 1. The print statement for output 3 tells the system
        to print the value at the memory address reffered to by the variable arr by 
        adding an asterisk symbol (*) before it.
    */
   
   return 0;
}