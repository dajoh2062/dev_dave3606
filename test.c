#include <stdio.h>

//  gcc test.c;./a.out

int main(void) {
    int value = 2000000000;
    int* pointer = &value;

    printf("%p\n", pointer);
    printf("value via pointer: %d, value direct: %d\n", *pointer, value);
    return 0;
}
