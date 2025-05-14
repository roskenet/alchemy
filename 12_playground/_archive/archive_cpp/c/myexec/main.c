#include <stdio.h>
//#include <stdbool.h>
#include "mykillerfunc.h"
#include "assert.h"
int main() {

    int doSomething = do_something(42);

    printf("Hello, World!\nmy_bool is: %d\n", doSomething);

    do_something_else();

    struct my_cool_struct a;
    a.an_int  =  42 ;

    printf("In mystruct steht: %d\n", a.an_int);

    return 0;
}
