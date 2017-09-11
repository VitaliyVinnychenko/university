#include "stdafx.h"
#include <iostream>
#include <vector>
#include <cstdio>
#include <cstdlib>
#include <climits>

using namespace std;
const short N = 5;

class Matrix {
	int matrix[N][N];
private:
	long long i, j;
	vector<int> row_product;
public:
	void input_matrix();
	void write_matrix();
	void make_row_product();
	void write_products();
	void average_product_value();
	void selection_sort(int row);
};

void Matrix::input_matrix() {
	cout << "Write matrix:" << endl;

	for (i = 0;i < 5;i++) {
		for (j = 0;j < 5;j++) {
			cin >> matrix[i][j];
		}
	}

	cout << "\n\nInput matrix:" << endl;

	for (i = 0;i < 5;i++, cout<<endl) {
		for (j = 0;j < 5;j++) {
			printf("%4d ", matrix[i][j]);
		}
	}
}

void Matrix::selection_sort(int row) {

	for (i = 0;i < N;i++) {
		int max = matrix[row][i], max_index = i;

		for (j = i;j < N;j++) {
			if (matrix[row][j] > max) {
				max = matrix[row][j];
				max_index = j;
			}
		}
		swap(matrix[row][i], matrix[row][max_index]);
	}
}

void Matrix::make_row_product() {

	for (i = 1; i < N; i++) {
		long long result = 1;

		for (j = N - 1;j > N - i - 1;j--) {
			result *= matrix[j][i];
		}
		row_product.push_back(result);
	}
}

void Matrix::write_products() {
	cout << "\nProducts list:" << endl;

	for (i = 0;i < N - 1;i++) {
		cout << row_product[i] << ' ';
	}
	cout << endl << endl;
}

void Matrix::write_matrix() {
	cout << endl << "Sorted matrix:" << endl;

	for (i = 0;i < 5;i++, cout << endl) {
		for (j = 0;j < 5;j++) {
			printf("%4d ", matrix[i][j]);
		}
	}
}

void Matrix::average_product_value() {
	long long result = 0;

	for (i = 0;i < N - 1;i++) {
		result += row_product[i];
	}
	cout << "Result: " << result / (N - 1) << endl << endl;
}

int main(void) {
	Matrix M;

	M.input_matrix();
	for (int row = 0;row < N;row++) {
		M.selection_sort(row);
	}

	M.write_matrix();
	M.make_row_product();
	M.write_products();
	M.average_product_value();

	system("PAUSE");
	return 0;
}
