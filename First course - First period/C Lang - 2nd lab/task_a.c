#include <stdio.h>
#include <math.h>

int main() {
	double h, a, b, x, result;

	printf("H = ");
	scanf("%lf", &h);

	printf("A = ");
	scanf("%lf", &a);

	printf("B = ");
	scanf("%lf", &b);

	for (x = a;x < b;x += h) {

		if (x <= 3) {
			result = log(pow(x, 3));
		}

		if (x > 3 && x < 4.5) {
			result = 1 / abs(sin(x));
		}

		if (x >= 4.5) {
			result = 1 / cos(1 / x);
		}

		printf("%lf  ->  %lf\n", x, result);
	}

    return 0;
}
