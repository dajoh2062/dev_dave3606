#include <stdio.h>


void add(int a, int b, int* sum){
    printf("Address if sum inside add(): %p\n", (void*)sum);

    *sum = a + b;
}

int main(){
    int sum;
    add (3,4, &sum);
    printf("sum: %d\n", sum);




    return 0;
}