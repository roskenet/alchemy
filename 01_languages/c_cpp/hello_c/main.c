#include <stdio.h>

char* get_greeting() {
    return "Hello, World!";
}

int main(void) {
    printf("%s\n", get_greeting());
    return 0;
}
