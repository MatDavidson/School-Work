/* This series of examples demonstrate the nuances of reading 
and writing (with format) strings (character arrays) in C */

#include<stdio.h>

#define SIZE 20
int main(){
    
    // ============ Writing a string using printf() ============ 
    char msg[] = "Are you still okay with C?";

    printf("%s\n", msg); 
    // printf() continues (char by char) until it finds an end-of-string character. If 
    // not found at the end of the string, it continues until it finds a null character.

    //Does the above explains overflow in print statements in example 13A?

    //Now uncomment the following line and check the output:

    //printf("%.10s", msg); // %.Ns is a specifier that tells how many chars (here, N) to be printed.

    // what would happen if we specify a number larger than the string length?

    // ============ Reading of a string using scanf() ============ */

    /* Now you may comment out the previous section and uncomment the following */
    
    /*
    char inputmsg[SIZE];
    puts("Enter your message:");
    scanf("%s", inputmsg); // You can enter the same string as above
    printf("%s\n", inputmsg); // check the output: is anything odd?

    printf("Size of the string = %d\n", sizeof(inputmsg));
    // Now uncomment the following two lines and check the output
    scanf("%s", inputmsg);
    printf("%s\n", inputmsg);
    // Can you guess what is happening?

    // What will happen if we put another pair of scanf()-printf() for inputmsg?
    */
    puts("Done with the example!");

    return 0;
}