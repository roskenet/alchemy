/*
 ============================================================================
 Name        : arraybug.c
 Author      : Felix Roske
 Version     :
 Copyright   : MIT
 Description : Find the bug!
 ============================================================================
 */

#include<stdio.h>

#define TOTAL_ELEMENTS (sizeof(array) / sizeof(array[0]))
int array[] = { 23, 34, 12, 17, 204, 99, 16 };

int main() {
	int d;

//	for (d = 0; d <= 6; d++) {
//		printf("%d\n", array[d + 1]);
//	}

//	for (d = -1; d <= 5; d++)
	for (d = -1; d <= (TOTAL_ELEMENTS - 2); d++)
		printf("%d\n", array[d + 1]);

	return 0;
}
