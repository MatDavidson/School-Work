/* Program illustrating different data types and output format */
#include <stdio.h>

#define G 675.7 /* Define is a way to declare the globals */

int main(){
	
	int x = 12345;
	float y = 123.4567;	
	char z = 'W';
	char st[] = "Hello World!"; /* Strings are character arrays */
	
	printf("The global constant is %f\n",G);
	printf("Int is %3i, Float is %4.2f, and Char is %c\n", x, y, z);
	printf("String is %s\n", st);
	
	return 0;
}