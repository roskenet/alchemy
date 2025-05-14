#include <iostream>

struct Foo {
    Foo() {
        std::cout << "Constructed" << std::endl;
    }
    Foo(const Foo &) {
        std::cout << "Copy constructed" << std::endl;
    }
    Foo(Foo &&) {
        std::cout << "Move constructed" << std::endl;
    }
    ~Foo() {
        std::cout << "Destructed" << std::endl;
    }
    Foo operator=(const Foo&) {
        std::cout << "Assignment overload" << std::endl;
    }
};

Foo f1() {
    return Foo();
}

int main() {
    Foo foo1 = f1();
    std::cout << "***" << std::endl;

    foo1 = f1();
    std::cout << "***" << std::endl;
}
