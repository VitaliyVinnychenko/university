#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

short k = 0;
const short n = 2;
const double eps = 0.00001, X = 1.5, Y = -1.5, H = 0.01;
vector<double> x, y, old_x, old_y;


double function1(double x, double y) {
    return 4 * x * x + y * y - 4;
}

double function2(double x, double y) {
    return x - y * y + 2;
}

bool stop_iteration() {
    if ()
    
    return true;
}

int main() {
    short e[n][n], i = 0, j = 0;
    double f[n];
    
    x.push_back(X);
    y.push_back(Y);
    
    for (; i < n; i++) {
        for (; j < n; j++) {
            e[i][j] = (i == j) ? 1 : 0;
        }
    }
    
    do {
        
    } while(stop_iteration())
    
    return 0;
}
