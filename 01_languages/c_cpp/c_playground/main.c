#include <stdio.h>
#include <stdbool.h>

/*
 * The evil difference between remainder and modulo
 */

bool isOdd(int n) {
    return n % 2 == 1;
}

int main(void) {
    const int testNumber = -3;

    char *result;
    if (isOdd(testNumber) == true) {
        result = "Odd";
    } else {
        result = "Even";
    }

    printf("%d is %s", testNumber, result);
}
