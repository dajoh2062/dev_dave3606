#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* create_int(int value){
    int* p = (int*) malloc(sizeof(int));

    //Task a
    *p = value;
    return p;
}

int main(){

    int* a = create_int(10);
    int* b = create_int(20);

    // Task b
    free(a);
    free(b);
    return 0;

    // Task c

    a=NULL;
    b=NULL;

    // Task d
    // Free(x) only hands the memory block back to the allocater, but a still points to the same
    // place. So setting a to null helps undefined behaviour such as dereferencing a after free(a), and 
    // incase we call free(a) twice which is also undefined behaviour.

    
}