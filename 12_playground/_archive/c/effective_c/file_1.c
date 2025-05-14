#include <stdio.h>
#include <stdlib.h>

void doSomething(void *);

int main(void) {
    puts("Hello, world!");

    size_t theSize = sizeof (int [4]);
    void *myPtr = malloc(theSize);

    int *myIntPtr = (int *) myPtr;

    doSomething(myPtr);

    char *theString = "HelloWorld";
    doSomething(theString);

    return EXIT_SUCCESS;
}

void doSomething(void *thePtr) {

    long *char_ptr = (char *) thePtr;

    printf("myLongs contains: %d\n\n", char_ptr[3]);

    free(thePtr);
}
