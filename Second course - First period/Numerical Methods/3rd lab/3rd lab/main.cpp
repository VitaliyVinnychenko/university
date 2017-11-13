#include <cstdio>
#include <cmath>
#include <iostream>
using namespace std;

void func(double *x, double *f) {
    f[0] = 4 * x[0] * x[0] + x[1] * x[1] - 4;
    f[1] = x[0] - x[1] * x[1] + 2;
}

int main(){
    double x[2] = {1.5, -1.5}, x_old[2] = {1.5, -1.5}, J[2][2], f[2], x_[2], f_[2];
    double ee = 1e-8, h = 1e-8;
    double INVERS[2][2], E[2][2], V[2][2], C[2][2], P[2], X[2], Y[2];
    
    bool cord_N;
    int n = 2, i, j, k;
    
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            E[i][j] = (i == j) ? 1 : 0;
        }
    }
    
    do {
        cord_N = false;
        func(x, f);
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                
                for (k = 0; k < n; k++) {
                    x_[k] = x[k];
                }
                
                x_[j] = x[j] + h;
                func(x_, f_);
                J[i][j] = (f_[i] - f[i]) / h;
            }
        }
        
        for (int b = 0; b < n; b++) {
            
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    V[i][j] = J[i][j];
                    P[i] = E[i][b];
                }
            }
            
            for (k = 0; k < n; k++) {
                Y[k] = P[k] / V[k][k];
                
                for (i = k + 1; i < n; i++) {
                    P[i] += -V[i][k] * Y[k];
                    
                    for (j = k + 1; j < n; j++) {
                        C[k][j] = V[k][j] / V[k][k];
                        V[i][j] += -V[i][k] * C[k][j];
                    }
                }
            }
            
            X[n - 1] = Y[n - 1];
            for (i = n - 2; i >= 0; i--) {
                X[i] = 0;
                
                for (j = i + 1; j < n; j++) {
                    X[i] += C[i][j] * X[j];
                }
                X[i] = Y[i] - X[i];
            }
            
            for (i = 0; i < n; i++) {
                INVERS[i][b] = X[i];
            }
        }
        
        for (i = 0; i < n; i++) {
            x[i] = 0;
            
            for (j = 0; j < n; j++) {
                x[i] += INVERS[i][j] * f[j];
            }
            x[i] = x_old[i] - x[i];
        }
        
        for (i = 0; i < n; i++) {
            cord_N = cord_N || fabs((x[i] - x_old[i]) / x[i] * 100) > ee;
            x_old[i] = x[i];
        }
    } while(cord_N);
    
    cout << "Result: ";
    for (i = 0; i < n; i++) {
        cout << x[i] << ' ';
    }
    
    func(x, f);
    cout << "\nTest: " << f[0] << ' ' << f[1] << "\n\n";
    
    return 0;
}
