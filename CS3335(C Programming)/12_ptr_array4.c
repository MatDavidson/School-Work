/* Example demosntrates how character array and character 
   literals are treated separately by pointers. */
  

#include<stdio.h>

int main(){
  int i, j;
   
  char st[] = "Hallo";
  char *chpt = st;
  *(chpt+1) = 'e';
  for(i=0; i<5; i++){
     printf("%c\t",*(chpt+i));
    }
    printf("\n\n");

 /* The above code will run perfect. Now
 comment out line 10 - 16. Uncomment the
 following code (except line 23) and 
 compile/execute it. */
/* 
char *chpt1 = "Hallo";
  *(chpt1 + 1) = 'e'; // uncomment after you try this part
for(j=0; j<5; j++){
     printf("%c\t", *(chpt1+j));
}
printf("\n\n");
*/

/* Now, uncomment line 24 and compile the 
code. Now try to run it. You will get a 
"segmentation fault" as the pointer cannot 
modify the string literal which is immutable. 
It is technically not an array. */

/* Now modify the line 23 declaration as follows:
const char *chpt1 = "Hallo";
The 'const' keyword will move the runtime error 
to compile time. */

return 0;
}