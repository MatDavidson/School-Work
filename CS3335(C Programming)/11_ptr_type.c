/* Example shows why we need a pointer type, when pointers are nothing but adresses.
It is because pointer arithmatic manipulates different pointers in different ways 
based pn internal storage of a data type. */

#include<stdio.h>

int main(){
    char char_arr[5] = {'A', 'B', 'C', 'D', 'E'};

    int int_arr[5] = {3, 5, 6, 7, 8};

    char *c = char_arr;
    int *i = int_arr;

    printf("\nCharacter array starts at location: %p\n", c);
    printf("Integer array starts at location: %p\n\n", i);

    printf("2nd item in character array is at address: %p\n", c+1);
    printf("2nd item in integer array is at address: %p\n\n", i+1);

    printf("Value at 2nd location (character array) = %c\n", *(c+1));
    printf("Value at 2nd location (integer array) = %d\n\n", *(i+1));

    
    printf("Address of c = %p and address of i = %p\n", &c, &i);
    printf("Size of c = %d and size of i = %d\n\n", sizeof(c), sizeof(i));

    return 0;
}