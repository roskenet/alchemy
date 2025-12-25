#include<iostream>
#include<cmath>

using namespace std;

int test_func() {
    const auto my_str = "Hello World";
//    int my_int { true };
}

int main() {
    float x;
    cout << "x eingeben:";
    cin >> x;

    cout << " x = " << x << '\n';
    cout << " fabs(x) = " <<
         fabs(x) << '\n';
    cout << " sqrt(x) = " <<
         sqrt(x) << '\n';
    cout << " sin(x) = " <<
         sin(x) << '\n'; // Argument von sin() im Bogenmaß!
    cout << " exp(x) = " <<
         exp(x) << '\n';
    cout << " log(x) = " <<
         log(x) << endl; // log() ist der natürliche Logarithmus

    test_func();

    return 0;
}

