/* Example shows though array variables behave like a pointer, but they are 
not actually pointers. There are some differences between these two. */

#include<stdio.h>

int main(){
    int arr[6] = {3, 5, 6, 7, 8, 9};
    int x = 4;
    
    printf("Value of x = %d and address of x = %p\n\n", x, &x);

    int *pt = arr;

   /* printf("Value of arr = %p and address of arr = %p\n", arr, &arr);

    printf("Value of pt = %p and address of pt = %p\t", pt, &pt);

    printf(" and size of arr = %d\t", sizeof(arr));

    printf(" and size of pt = %d\n\n", sizeof(pt)); */

    /* What can we conclude (infer) from last 4 lines of printf()? */

    /* After finding the conclusion above, comment out the previous 4 printf() 
    statements, and uncomment the two pair of lines, but not at once. Try 
    them separately. That is, first uncomment only the next two lines, compile, 
    and run. Then uncomment the next two lines and compile. */
    
    /*  
    pt = &x;
    printf("Value at location pointed by pt = %d\n", *pt);
    */

    /*
    arr = &x;
    printf("Value at location pointed by arr = %d\n", *arr);
    */

    return 0;
}