/* Example illustrates use of typedef --  a way to define custom data type */
/* This example demonstrates defining new types of existing basic type */

#include<stdio.h>

typedef int wholeNumber; /*int is now called 'wholeNumber' */
typedef char symbols;    /* char data type is now represented as 'symbols' */  

wholeNumber main(){
	puts("Enter an integer, followed by a character:");
	
	wholeNumber a; 
	symbols b;

	scanf("%d %c",&a, &b);

	printf("Your integer is %d and the character is %c\n", a, b);
   
	return 0;
}