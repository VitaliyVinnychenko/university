#include <iostream>
#include <vector>
using namespace std;

int elements_number;
vector <int> order;

void reverse(int end) {
    int begin = 0;
    while (begin < end) {
        swap(order[begin++], order[end--]);
    }
}

void anti_lexicographical_order(int number) {
    int iterator;

    if (!number) {
        int left_sum = 0, right_sum = 0, half_en = elements_number / 2;

        for (iterator = 0; iterator < half_en; iterator++) {
            left_sum += order[iterator];
            right_sum += order[iterator + half_en];
        }

        if (left_sum == right_sum) {
            for (auto item : order){
                cout << item << ' ';
            }
            cout << endl;
        }
    } else {
        for (iterator = 0; iterator <= number; iterator++) {
            anti_lexicographical_order(number - 1);
            if (iterator < number) {
                swap(order[iterator], order[number]);
                reverse(number - 1);
            }
        }
    }
}

int main() {
    cin >> elements_number;
    for (int iterator = 0; iterator < elements_number; iterator++) {
        order.push_back(iterator + 1);
    }
    anti_lexicographical_order(elements_number - 1);
    return 0;
}
