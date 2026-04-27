#include <stdio.h>

int main() {
    int x = 5;
    double y = 3.14;
    char c = 'A';

    printf("%zu\n", sizeof(x));         // usually 4
    printf("%zu\n", sizeof(y));         // usually 8
    printf("%zu\n", sizeof(c));         // 1

    printf("%zu\n", sizeof(int));       // usually 4
    printf("%zu\n", sizeof(double));    // usually 8
    printf("%zu\n", sizeof(char));      // 1

    int arr[] = {10, 20, 30, 40};
    printf("%zu\n", sizeof(arr));       // usually 16 (4 ints * 4 bytes each)
    printf("%zu\n", sizeof(arr[0]));    // usually 4
    printf("%zu\n", sizeof(arr) / sizeof(arr[0])); // 4

    char str[] = "hello";
    printf("%zu\n", sizeof(str));       // 6 ('h','e','l','l','o','\0')

    int *ptr = arr;
    printf("%zu\n", sizeof(ptr));       // usually 8 on 64-bit system, 4 on 32-bit

    return 0;
}