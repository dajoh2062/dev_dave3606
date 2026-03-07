
//  gcc test.c;./a.out
#include <stdio.h>

int square(int x) {
    return x * x;
}

int main() {

    int a = 5;
    double b = 3.14;
    char name[] = "C";

    if (a > 0) {
        printf("%s square: %d\n", name, square(a));
    }

    for (int i = 0; i < 3; i++) {
        printf("i = %d\n", i);
    }

    return 0;
}
