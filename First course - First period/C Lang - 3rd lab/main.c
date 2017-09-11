#include <stdio.h>

const short N = 5;
int i, j, result[N];

void bubble_sort(int array[][N], int row) {
	int change = 0;
	bool flag = true;

	while (flag){
		flag = false;

		for (i = 0; i < (N - 1); i++) {

			if (array[row][i] > array[row][i + 1]) {
				change = array[row][i];

				array[row][i] = array[row][i + 1];
				array[row][i + 1] = change;

				flag = true;
			}
		}
	}
}

void write_matrix(int matrix[][N]) {

	for (i = 0;i < N;i++, printf("\n")) {
		for (j = 0;j < N;j++) {
			printf("%d ", matrix[i][j]);
		}
	}
	printf("\n");
}

void min_column_value(int matrix[][N]) {
	int min;

	for (i = 0;i < N;i++) {
		min = 1000000000;

		for (j = 0;j < N;j++) {
			min = min > matrix[j][i] ? matrix[j][i] : min;
		}
		result[i] = min;
	}
}

void write_min_values() {
	printf("Min values:\n");

	for (i = 0;i < N;i++) {
		printf("%d ", result[i]);
	}
	printf("\n");
}

long long product_min_values() {
	long long answer = 1;

	for (i = 0;i < N;i++) {
		answer *= result[i];
	}
	return answer;
}

int main(void) {
	int matrix[N][N], i ,j;

	printf("Write matrix:\n");
	for (i = 0;i < N;i++) {

		for (j = 0;j < N;j++) {
			scanf("%d", matrix[i][j]);
		}

		bubble_sort(matrix, i);
	}

	printf("\nSorted matrix:\n");

	write_matrix(matrix);
	min_column_value(matrix);
	write_min_values();

	printf("\nResult: %d\n\n", product_min_values());
    return 0;
}
