/*Emily Shirley, Mat Davidson
CS4345 - OS
Spring 2020
Assignment 1 */

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include<sys/types.h>
 
int collatz(int num){
    if(num == 1||num == 2){ 
        printf("1");
        return 1;
    }
    else if(num%2 == 0){ 
        printf("%d, ", num/2);
        return(collatz(num/2));
    }
    else{                
        printf("%d, ", num*3 + 1);
        return(collatz(num*3+1));
    }
}

int main(){
    pid_t procid;
    procid = fork();

    if(procid>0){
        printf("PID: %d - Parent begin...\n\tWaiting for child process to end...\n", procid);
        wait(NULL); 
        printf("\n\tControl returns to parent.\n");
        printf("PID: %d - Parent end.", procid);
    }
    else if(procid==0){
        int num;
        printf("\nPID: %d - Child begin...", procid);
        printf("\n\tEnter a positive integer: ");
        scanf("%d", &num);

        while(num < 1){
            printf("\n\tInvalid input. Please enter a positive integer: ");
            scanf("%d", &num);
        }
        printf("\n\tGenerating Collatz sequence...\n\t%d, ", num);
        collatz(num);
        printf("\nPID: %d - Child end.\n", procid);
    }
    else{
       fprintf(stderr, "Error");
       return 1; 
    }

return 0;
}
