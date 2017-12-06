#include <math.h>
#include <iostream>
using namespace std;

#define PI 3.14
#define E 0.001
#define H 0.00001

double Umax = 100, U1, U2, R1 = 5, R2 = 4, R3 = 7, R4 = 2, C = 300e-6, L = 0.01, T = 0.1, f = 50;
double Y[2] = { 0, 0 }, X[2], Z[2];

int main() {
    bool condition;
    
    for (double t = H; t <= (T + H / 2); t += H) {
        U1 = Umax * sin(2 * PI * f * t);
        Z[0] = Y[0];
        Z[1] = Y[1];
        
        do {
            condition = false;
            
            X[0] = Y[0] + H * (1 / C * (U1 - Z[0] - Z[1] * R3 - L * Z[1] - Z[1] * R4) / R1);
            X[1] = Y[1] + H * (1 / L * (Z[0] * C * R2 - Z[1] * (R2 + R3 + R4)));
            
            condition = condition || fabs((X[0] - Z[0]) / X[0] * 100) > E
                || fabs((X[1] - Z[1]) / X[1] * 100) > E;
            
            Z[0] = X[0];
            Z[1] = X[1];
        } while (condition);
        
        Y[0] = X[0];
        Y[1] = X[1];
        U2 = X[1] * R4;
        
        cout << t << " " << U2 << endl;
    }
}
