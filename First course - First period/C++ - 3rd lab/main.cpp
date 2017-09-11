#include <iostream>
using namespace std;

#define N 5

class Array {
private:
    double classArray[N];
public:
    Array();
    Array(double array[]);
    double getItem(int i){return classArray[i];};
    void setItem(double arrayItem, int i){classArray[i] = arrayItem;};
    Array operator + (Array & array);
    Array operator * (Array & array);
    bool operator == (Array & array);
    friend istream &operator >> (istream & stream,Array & A);
    friend ostream &operator << (ostream & stream,Array & A);
    friend void operator -= (Array & operatedArray, Array & array);
};

Array::Array() {
    for(int i = 0; i < N; i++){
        classArray[i] = 1 + rand() % 10000;
    }
}

Array::Array(double array[]) {
    for(int i = 0; i < N; i++){
        classArray[i] = array[i];
    }
}

Array Array::operator * (Array & array) {
    Array A;

    for(int i = 0; i < N; i++){
        A.setItem(classArray[i] * array.getItem(i), i);
    }
    return A;
}

Array Array::operator + (Array & array) {
    Array A;

    for(int i = 0; i < N; i++){
        A.setItem(classArray[i] + array.getItem(i), i);
    }
    return A;
}

istream &operator >> (istream & stream,Array & A) {

    for(int i = 0; i < N; i++){
        stream >> A.classArray[i];
    }
    return stream;
}

ostream &operator << (ostream & stream,Array & A) {
    for(int i = 0; i < N; i++){
        stream << A.classArray[i];

        if(i != N - 1){
            stream << ", ";
        }
    }
    return stream;
}

void operator -= (Array & operatedArray, Array & array) {
    for(int i = 0; i < N; i++){
        operatedArray.setItem(operatedArray.getItem(i) - array.getItem(i), i);
    }
}

bool Array::operator==(Array &array) {
    for(int i = 0; i < N; i++){

        if(classArray[i] != array.getItem(i)){
            return false;
        }
    }
    return true;
}

int main() {
    double testArray[N] = {1, 5, 2, 4, 3};
    Array myArray1, myArray2(testArray), myArray3;
    
    cout << "Без ініціалізації(myArray1): [" << myArray1 << "]\n";
    cout << "З ініціалізацією(myArray2): [" << myArray2 << "]\n";
    cout << "Введіть масив myArray3: ";
    cin >> myArray3;

    cout << "Введений користувачем масив(myArray3): [" << myArray3 << "]\n";
    myArray1 = myArray2 + myArray3;

    cout << "myArray2 + myArray3 = [" << myArray1 << "]\n";
    myArray1 = myArray3 * myArray2;
    cout << "myArray2 * myArray3 = [" << myArray1 << "]\n";
    myArray2 -= myArray3;
    cout << "myArray2 -= myArray3 => [" << myArray2 << "]\n";

    if(myArray2 == myArray3){
        cout << "[" << myArray2 << "] == [" << myArray3 << "]\n";
    } else {
        cout << "[" << myArray2 << "] != [" << myArray3 << "]\n";
    }

    cout << endl;
    return 0;
}
