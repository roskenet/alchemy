#include <stdio.h>

void funWithPointers();

char* get_greeting() {
    return "Hello, World!";
}

int main(void) {
    // printf("%s\n", get_greeting());
    funWithPointers();
    return 0;
}

void funWithPointers() {
    int x = 5;
    int y = 42;

    int* ptr = &x;

    printf("%d\n", *ptr);

    x = 10;
    printf("%d\n", *ptr);
}
