#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

const double EPSILON = 0.0001, STEP = 0.05, A = -2.5;


double func(double x) {
    return x * x - cos(x);
}

bool stop_iteration(double x, double x_old) {
    return (x - x_old) / x < EPSILON;
}

int main() {
    
    // пошук ділянки локалізації
    double a = A, b = A + STEP;
    double fa = func(a), fb = func(b);
    double h = (fabs(fb) > fabs(fa) && fa * fb > 0) ? -1 * STEP : STEP;
    
    b = a + h;
    fb = func(b);
    
    while (fa * fb > 0) {
        a = b;
        b = a + h;
        fa = func(a);
        fb = func(b);
    }
    
    // ітерація
    double x = a, x_old;
    
    do {
        fa = func(a);
        fb = func(b);
        
        x_old = x;
        x = a - fa * ((b - a) / (fb - fa));
        
        if (func(x) * fa > 0) {
            a = x;
        } else {
            b = x;
        }
    } while (stop_iteration(x, x_old));
    
    cout << x << endl;
    return 0;
}
