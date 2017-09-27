#include <iostream>
#include <cmath>
using namespace std;


const int N = 3;

float A[N][N] = {
    {24.21, 2.42, 3.85},
    {2.31, 31.49, 1.52},
    {3.49, 4.84, 28.72}
};

float B[N] = {30.24, 40.95, 42.81};

float X[30][N] = {0};
float TEST[N];
float sum;
float eps;
int iterations = 0;


bool ExitFunc(float eps) {
    if (iterations == 0) {
        return true;
    }
    
    for (int i = 0; i < N; i++) {
        
        if (fabs(X[iterations][i] - X[iterations - 1][i]) > eps) {
            return true;
        }
    }
    
    return false;
}


void show_results() {
    cout << "\nResult: ";
    for (int j = 0; j < N; j++) {
        printf("%4.8f ", X[iterations][j]);
    }
}


void run_and_show_tests() {
    cout << "\nTest: ";
    
    for (int i = 0; i < N; i++) {
        
        for (int j = 0; j < N; j++) {
            TEST[i] += (A[i][j] * X[iterations][j]);
        }
        
        printf("%.5f ", TEST[i]);
    }
}


void iterate_matrix() {
    for (int i = 0; i < N; i++) {
        sum = 0;
        
        for (int j = 0; j < N; j++) {
            if (i != j) {
                sum += A[i][j] * X[iterations][j];
            }
        }
        
        X[iterations + 1][i] = (1 / A[i][i]) * (B[i] - sum);
    }
}


int main(void) {
    cout << "Enter eps: ";
    cin >> eps;
    
    do {
        iterate_matrix();
        iterations++;
    } while (ExitFunc(eps));
    
    show_results();
    run_and_show_tests();
    
    cout << "\nIterations: " << iterations << "\n\n";
    
    return 0;
}

