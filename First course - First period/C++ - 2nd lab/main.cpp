#include <iostream>
#include <vector>
#include <cstdio>
#include <cstdlib>

using namespace std;

const short N = 5;
vector<double> average_values;

class Matrix {
private: 
    int M[N];
public:
    friend void merge_sort(int l, int r, int index);
    friend void input_matrix(Matrix *A);
    friend void output_matrix(Matrix *A);
    friend void compute_average_values(Matrix *A);
};

Matrix MainMatrix[N];

void merge_sort(int l, int r, int index) {
    if (r == l) {
        return;
    }
    if (r - l == 1) {
        if (MainMatrix[r].M[index] < MainMatrix[l].M[index]) {
            swap(MainMatrix[r].M[index], MainMatrix[l].M[index]);
        }
        return;
    }
    int m = (r + l) / 2;

    merge_sort(l, m, index);
    merge_sort(m + 1, r, index);

    int buf[N];
    int xl = l;
    int xr = m + 1;
    int cur = 0;

    while (r - l + 1 != cur) {

        if (xl > m) {
            buf[cur++] = MainMatrix[xr++].M[index];
        } else if (xr > r) {
            buf[cur++] = MainMatrix[xl++].M[index];
        } else if (MainMatrix[xl].M[index] > MainMatrix[xr].M[index]) {
            buf[cur++] = MainMatrix[xr++].M[index];
        } else {
            buf[cur++] = MainMatrix[xl++].M[index];
        }
        
    }
    for (int j = 0; j < cur; j++) {
        MainMatrix[j + l].M[index] = buf[j];
    }
}

void input_matrix(Matrix *A) {
    cout << "Write matrix:\n";

    for (int i = 0;i < N;i++) {
        for (int j = 0;j < N;j++) {
            cin >> A[i].M[j];
        }
    }
}

void output_matrix(Matrix *A) {
    for (int i = 0;i < N;i++, cout << endl) {
        for (int j = 0;j < N;j++) {
            printf("%4d ", A[i].M[j]);
        }
    }
}

void compute_average_values(Matrix *A) {
    for (int i = 0;i < N;i++) {
        double result = 0;

        for (int j = 0;j < N;j++) {
            result += A[i].M[j];
        }
        average_values.push_back(result / N);
    }
}

void write_average_values() {
    cout << "\nAverage values:\n";
    for (int i = 0;i < N;i++) {
        cout << average_values[i] << ' ';
    }
    cout << endl;
}

void multipy_average_values() {
    double result = 1.0;

    for (int i = 0;i < N;i++) {
        result *= average_values[i];
    }
    cout << "\nResult: " << (double)result << "\n\n";
}

int main() {
    input_matrix(MainMatrix);

    cout << "\nInput matrix:\n";
    output_matrix(MainMatrix);

    for(int i = 0; i < N; i++){
        merge_sort(0, N - 1, i);
    }

    cout << "\nSorted matrix:\n";
    output_matrix(MainMatrix);

    compute_average_values(MainMatrix);
    write_average_values();
    multipy_average_values();

    return 0;
}
