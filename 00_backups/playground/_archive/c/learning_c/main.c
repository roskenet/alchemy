#include<stdio.h>
#include<stdlib.h>

int main() {
    printf("Hello, World!\n");

    typedef struct {
        char c[10];
        int i;
        double d;
    } widget;

    void *memory = malloc(sizeof(widget));

    widget *w = memory;

    w->i = 42;
    w->d = 3.14;

    free(w);
    w = NULL;

    return 0;
}

