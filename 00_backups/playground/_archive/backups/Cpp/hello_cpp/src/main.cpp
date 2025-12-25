#include <iostream>

void do_something(int &i) {
    std::cout << "In i steht: " << i << std::endl;
}

int main() {
    auto i{42};
    do_something(i);
    return 0;
}
