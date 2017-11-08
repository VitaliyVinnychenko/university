#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define SQR(X) ((X)*(X))
#define N 2
#define EPS 0.00001

double f0(double x[N]) { return 4 * SQR(x[0]) + SQR(x[1]) - 4; }
double f1(double x[N]) { return x[0] - SQR(x[1]) + 1; }

double f00(double x[N]) { return 8 * x[0] + 2 * x[1]; }
double f01(double x[N]) { return 1 - 2 * x[1]; }

double f10(double x[N]) { return 10; }
double f11(double x[N]) { return -2; }

double x[N] = {
    1.5,
    -1.5
};

double (*f[N])(double *) = {
    f0,
    f1
};

double (*ff[N][N])(double *) = {
    { f00, f01 },
    { f10, f11 }
};

double fx[N];
double ffx[N][N];
double ffx1[N][N];

double nevyazka;

void printX()
{
    for (int i = 0; i < N; i++)
        printf("%10f ", x[i]);
    printf("\n");
}

void print(int t)
{
    printf("%3i | %12f | ", t, nevyazka);
    printX();
}

int main(){
    for (int t = 0; t < 100; t++){
    
        for (int i = 0; i < N; i++) {
            fx[i] = f[i](x);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ffx[i][j] = ff[i][j](x);
            }
        }
    
        memset(ffx1, 0, N*N*sizeof(double));

        for (int i = 0; i < N; i++)
            ffx1[i][i] = 1;
        
        double  r;
    
        for (int i = 0; i < N; i++)
        {
            if (ffx[i][i] == 0) {
                for (int p = i+1; p < N; p++) {
                    if (ffx[p][i] != 0) {
                        // если нашли нужную строку, то меняем строки i и p местами
                        for (int q = 0; q < N; q++) {
                            int t = ffx[i][q];
                            ffx[i][q] = ffx[p][q];
                            ffx[p][q] = t;
                        }
                        // поменяли строки? продолжаем алгоритм, прервав цикл
                        break;
                    }
                }
            }
            // если замены нулевого элемента не было
            if (ffx[i][i] == 0) {
                printf("[!] Devizion by zero in 'Gauss method'\n");
                return 1;
            }
            
            for (int k = 0; k < N; k++) {
                if (i == k) continue;

                r = ffx[k][i] / ffx[i][i];
                
                for (int j = 0; j < N; j++) {
                    ffx[k][j] -= r * ffx[i][j];
                    ffx1[k][j] -= r * ffx1[i][j];
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            r = ffx[i][i];
            for (int j = 0; j < N; j++) {
                ffx[i][j] /= r;
                ffx1[i][j] /= r;
            }
            
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double dx = 0;
                for (int k = 0; k < N; k++)
                    dx += ffx1[i][k] * ff[k][j](x);
                printf("%10.2lf\t", fabs(dx));
            }
            printf("\n");
        }
        printf("\n\n");
        
        for (int i = 0; i < N; i++) {
            double dx = 0;
            for (int k = 0; k < N; k++)
                dx += ffx1[i][k] * fx[k];
            x[i] = x[i] - dx;
        }
        
        nevyazka = 0;
        for (int i = 0; i < N; i++)
            nevyazka += SQR( f[i](x) );
        nevyazka = sqrt(nevyazka);
        
        print(t);
        
        if (nevyazka < EPS) {
            break;
        }
        
        if (isnan(nevyazka)) {
            break;
        }
    }
    
    return 0;
}
