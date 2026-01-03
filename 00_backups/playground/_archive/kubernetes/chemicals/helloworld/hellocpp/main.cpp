#include <iostream>
#include "killerapp/myfunction.h"

int main() {
    std::cout << "Hello, World!" << std::endl;

    int myInt { 42 };

    int didSomething = doSomething(myInt);

    std::cout << "DidSomething: " << didSomething << std::endl;
    std::cout << "myInd is: " << myInt << std::endl;

    return 0;
}
