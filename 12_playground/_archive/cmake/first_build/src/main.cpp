#include<iostream>
#include<string>
#include <iomanip>

enum class Manufacturer {
   Sony,
   Hitachi,
   Samsung,
   Leica,

};

// prototype
void doSomething(int&);

int main() {
    std::cout << "Hello World!" << std::endl;

    u_int8_t myInt{42};

    float myFloat{3.1415926};

    std::setprecision(2);

    std::cout << "Value is " << std::setprecision(2) << myFloat << std::endl;

    std::cout << "Sticky settings: " << myFloat << std::endl;

    constexpr Manufacturer myCamera{Manufacturer::Samsung};

    if(myCamera == Manufacturer::Leica) {
        std::cout << "I don't own a Leica!";
    } else if (myCamera == Manufacturer::Samsung) {
        std::cout << "I own a Samsung!" << std::endl;
    }

    int theAnswer{42};
    doSomething(theAnswer);

    std::cout << "But now theAnswer is: " << theAnswer;

    return 0;
}

void doSomething(int& myReference) {
    std::cout << "The reference is: " << myReference << std::endl;
    myReference = 43;
}