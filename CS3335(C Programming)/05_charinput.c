/* scanf() can be tricky capturing input*/
/* Example illustrates how output differs for different format of argument specification */

#include<stdio.h>

int main(){
	char c1, c2, c3, c4, c5;
	puts("Enter three characters:");
	scanf("%c,%c,%c", &c1, &c2, &c3);
	//scanf("%c %c %c", &c1, &c2, &c3);
	puts("Enter two more characters:");
	scanf("%c,%c", &c4, &c5);
	//scanf("%c %c", &c4, &c5);
	printf("You have entered: %c %c %c %c %c\n\n", c1, c2, c3, c4, c5);	
}
