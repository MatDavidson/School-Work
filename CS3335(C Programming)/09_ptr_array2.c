/* Example shows how array name (the array variable) actually works like a pointer. */

#include<stdio.h>

int main(){
    int arr[6] = {3, 5, 6, 7, 8, 9};

    printf("Value at index 0 of the array: %d\n", *arr); //retrieving value at 0th index

    printf("Value at index 3 of the array: %d\n", *(arr+3)); // advancing pointer 3 locations and then retrieving the value

    printf("Value at index 3 (swapped representation): %d\n", 3[arr]);  // What???

    printf("Value at previous location, which is (3-1)[arr]: %d\n", (3-1)[arr]); // Are you kidding... array like this??

    printf("Value at the next location, which is ++3[arr]: %d\n", ++3[arr]); // It's nuts!! No way this is going to work.

    return 0;
}