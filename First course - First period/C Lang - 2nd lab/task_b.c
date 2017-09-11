#include <stdio.h>
#include <math.h>

int main() {
	double a, b, e, h, x, sum, iteration = 1.0;
	int k;

	printf("H = ");
	scanf("%lf", &h);

	printf("A = ");
	scanf("%lf", &a);

	printf("B = ");
	scanf("%lf", &b);

	printf("E = ");
	scanf("%lf", &e);

	printf("\nResult:\n");
	for (x = a; x <= b; x += h) {

		k = 1;
		iteration = 1.0;
		sum = 0;

		while (fabs(iteration > e)) {
			iteration = k * pow(x, k);
			sum += iteration;
			k++;
		}

		printf("%.2f  -->  %.5f\n", x, sum);
	}

	return 0;
}
