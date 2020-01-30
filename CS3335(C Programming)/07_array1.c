/* Example illustrates how arrays are treated in C and the use of
sizeof() operator. When array is passed as an argument to a function, 
it is treated as a pointer (an address). Hence, the function finds
sizeof(nums) as 8 (no. of bytes in 64-bit addressing) */

/* When sizeof() is used on the array numbers[] (which is a concrete 
array), the size is (number of items) x  (bytes to store each item)
Hence, it finds size 20 as there are 5 integers and each integer is
4 bytes long */

/* However, nums points to the same physical array indicated by numbers 
and hence, changing the cell value within the method using nums affects
the original array numbers[] */

#include<stdio.h>

void mymethod(int nums[]){
   printf("From method: size of array = %d\n", sizeof(nums));
   nums[0] = 7;
   return;
}

int main(){
   int numbers[5] = {11, 17, 23, 33, 38};
   printf("From main: size of array = %d\n", sizeof(numbers));
   
   mymethod(numbers);
   
   int i; 
   for(i=0; i<5; i++){
      printf("Array element %d is: %d\n", i, numbers[i]);
   }
   return 0;
}

/* Change the size of the array from 5 to 6, add another number in the array 
and run the program again. Note the similarities and differences in the output. */