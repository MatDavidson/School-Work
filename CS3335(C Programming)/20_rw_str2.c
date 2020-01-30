/* Example 2 of the series */

#include<stdio.h>


int main(){
    char inputmsg[20];

    puts("Enter your message:");
    scanf("%s", inputmsg); //enter a long string without any space and more than 20 characters (e.g., abracadabragilligilligey)
    //scanf("%20s", inputmsg);
    
    printf("%s\n", inputmsg); // What is the result of the output?
    
    // Now comment out line 10 and uncomment line 11; run the code and compare the output with previous

    // Now uncomment the following two lines and run the code with same input as before 
    /* 
    puts("Another input message:");
    scanf("%s", inputmsg);
    printf("%s\n", inputmsg); // what do you observe? would the same thing happen with line 10?
    */

return 0;
}