#include <iostream>

unsigned int countBits(unsigned long long n){
	unsigned int count = 0;
	int bitcount = 8*sizeof(unsigned long long);

	for(int x=0; x < bitcount; x += 1) {
		unsigned long long pattern = 1UL << x;
		if((n & pattern) == pattern) {
			++count;
		}
	}
	return count;
}

int main(int argc, char **argv) {
	unsigned int count = countBits(42);

	std::cout << "Hello! BitCount: " << count;

	return 0;
}
