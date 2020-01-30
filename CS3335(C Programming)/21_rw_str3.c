/* Example 3 of the series */

#include<stdio.h>
#include<string.h> // Now onward, we will add this header to deal with strings

int main(){
    char inputmsg[20];
    puts("Enter a message:");
    
    gets(inputmsg); // Enter the message: Are you still okay with C?
    printf("%s\n", inputmsg); // Did you see any change in the output from previous?

    // Now uncomment the following two lines and run the code again to analyze the output
   /* gets(inputmsg);
    printf("%s\n", inputmsg);
    */

    // Now, comment out lines 10 - 15, uncomment the following segment, and test the code for more explicit control
    /*
    char c; int i=0;
    while(i<20)
        inputmsg[i++] = getchar();
    
    inputmsg[i] = '\0';

    printf("Number of characters = %d\n", i);
    printf("%s\n", inputmsg);
    */

return 0;
}