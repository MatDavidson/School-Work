/* Compile the code and notice the prompt for any warning/error. Then try to run the executable. */

/* Once you did the above, cut the printData function and paste it before main() but after #define */
/* Now compile again, look for any warning/error message. Try to run the executable again */

#include <stdio.h>

#define G 675.7 /* Define is a way to declare the globals */

int main(){

	printData();
	
	return 0;
}

void printData(){
    int x = 12345;
	float y = 123.4567;	
	char z = 'W';
	char st[] = "Hello World!"; /* Strings are character arrays */

    printf("The global constant is %f\n",G);
	printf("Int is %3d, Float is %4.2f, and Char is %c\n", x, y, z);
	printf("String is %s\n", st);
}

/* What did you observe? */