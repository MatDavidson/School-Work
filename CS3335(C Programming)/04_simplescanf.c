/* Illustrates simple user input from console */ 

#include<stdio.h>

int main(){
	int n;
	puts("Enter an integer: ");
   /* don't try to combine scanf() with messages */
	scanf("%d", &n); /* For the time being just accept that & symbol is needed before char, float, int data types */

	printf("You have entered %d\n",n);
	return 0;
}
