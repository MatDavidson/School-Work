/*Mat Davidson - CS3335 - Fall 2019 */
#include<stdio.h>
int size, i, j, k, x, y;
int main (){
    puts("Enter an odd positive integer:");
    scanf("%d", &size);

    while(size%2 == 0 || size < 0){
        puts("Invalid input. Enter an odd positive integer:");
        scanf("%d", &size);
    }
    printf("You entered %d. I will now create a %d*%d magic square.\n", size, size, size);

    int a[size][size];
    for(int b = 0; b < size; b++){
        for(int c = 0; c < size; c++){
           a[b][c] = 0;
        }
    }
    i = 0;
    j = (int)size/2;
    k = 0;

    while(k < size*size){
        a[i][j] = k+1;
        k++;

        x = i;
        y = j;

        i -= 1;
        if(i < 0){
            i = size - 1;
        }
        j += 1;
        if(j > size - 1){
            j = 0;
        }
        if(a[i][j]){
            i = x + 1;
            j = y;
            if(i < 0){
                i = size - 1;
            }
        }
    }

    for(int b = 0; b < size; b++){
        for(int c = 0; c < size; c++){
            printf("\t%d", a[b][c]);
        }
        printf("\n");
    }
    x = 0;
    for(int b = 0; b < size; b++){
        x += *a[b];
    }
    printf("The magic number is: %d\n", x);
    return 0;
}