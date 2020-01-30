/*  Name: Mat Davidson
    Class: CS3335 - Fall 2019 */
#include<stdio.h>

int main(){
    int zero = 0;
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    int five = 0;
    int six = 0;
    int seven = 0;
    int eight = 0;
    int nine = 0;
    int temp;

    int num;

    puts("Enter a number:");
    scanf("%d", &num);

    printf("The number you entered: %d\n", num);    
    
    while(num > 0){
        temp = num%10;
        switch (temp){
            case 0:
                zero++;
                break;
            case 1:
                one++;
                break;
            case 2:
                two++;
                break;
            case 3:
                three++;
                break;
            case 4:
                four++;
                break;
            case 5:
                five++;
                break;
            case 6:
                six++;
                break;
            case 7:
                seven++;
                break;
            case 8:
                eight++;
                break;
            case 9:
                nine++;
                break;
            
            default:
                break;
        }
        num = num/10;
    }
    
    puts("Digit:\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9");
    printf("Freq.:\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n",zero,one,two,three,four,five,six,seven,eight,nine);
}