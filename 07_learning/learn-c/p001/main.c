#include <stdint.h>
#include <stdio.h>
#include <stdbool.h>

void printGreeting(char* name);
void printSomething(void);

int main(void)
{
    // printGreeting("Felix");
    printSomething();
    return 0;
}

void printGreeting(char* name)
{
    printf("Hello, %s!\n", name);

    unsigned long size = sizeof(name);
    unsigned char c = 'a';
    uint64_t myInt = 42;

    printf("The size of name is %lu bytes.\n", size);
    printf("The size of char is %lu bytes.\n", sizeof(c));
    printf("The size of myInt is %lu bytes.\n", sizeof(myInt));

}

void printSomething(void)
{
    bool isTrue = true;

    int x = 42;
    const unsigned int y = -42;

    printf("x = %d, y = %d\n", x, y);
}