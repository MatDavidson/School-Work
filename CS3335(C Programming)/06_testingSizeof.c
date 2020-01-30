/* Program illustrating different data types and output format */
#include <stdio.h>

int main(){
	
	int x = 3;
	float y = 123.4567;	
    double z = 123.4567;
	char w = 'G';
	char st[] = "Hello World!"; /* Strings are character arrays */
	
    puts("\n The following are the return value for sizeof() operator:\n");

	printf("Sizeof x = %d\n", sizeof(x));
	printf("Sizeof y = %d\n", sizeof(y));
    printf("Sizeof z = %d\n", sizeof(z));
    printf("Sizeof w = %d\n", sizeof(w));
    printf("Sizeof st[] = %d\n", sizeof(st));

	return 0;
}