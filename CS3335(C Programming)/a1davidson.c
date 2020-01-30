/*  Name: Mat Davidson
    Class: CS3335 - Fall 2019 */

    #include<stdio.h>
    #include<stdlib.h>
    #include<time.h>

    int main(){
        srand(time(NULL));
        int num = (rand() % 100); 
        int guess;
        puts("\n\nA number between 0 and 100 has been generated randomly.\nYou may try to guess the number 5 times."); 

        for(int i = 5; i > 0; i--){
            printf("%d attempts left.\nEnter your guess:  ", i);
            scanf("%d", &guess);

            if(guess > num){
                puts("You guessed too high!\n");
            }
            else if(guess < num){
                puts("You guessed too low!\n");
            }
            else{
                printf("Your guess is correct!\n%d is the number!\nYou used %d guesses.\n", num, 6-i);
                return 0;
            }
        }
        printf("You ran out of attempts!\nThe number was %d.\n", num);
        return 0;
    }