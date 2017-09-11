#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int array[10], elements_number, k;
    cin >> elements_number;

    for (int iterator = 0; iterator < elements_number; iterator++) {
        cin >> array[iterator];
    }
    k = (int) pow(2, elements_number);

    for (int iterator_i = 0; iterator_i < k; iterator_i++) {
        cout << "{";
        for (int iterator_j = 0; iterator_j < elements_number; iterator_j++) {
            if (iterator_i & (1 << iterator_j)) {
                cout << array[iterator_j] << " ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}