#include <iostream>
#include <cmath>
using namespace std;
const double A = 1.0, B = 2.0, N = 1000000;

double f(double x) {
    return x * pow(2, 2 * x);
}


int main(int argc, const char * argv[]) {
    double integral = 0, x = A, h = (B - A) / N;
    
    for (int i = 1; i < N; i++) {
        integral += f(x);
        x += h;
    }
    
    integral *= h;
    
    cout << 2 * integral << endl;
    
    cout << f(B) - f(A) << endl << endl;
    return 0;
}
