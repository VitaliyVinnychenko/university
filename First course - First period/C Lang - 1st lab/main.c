#include <stdio.h>
#include <math.h>
int main()
{
    double x, z;
	printf("X = ");
	scanf("%lf", &x);
	printf("Y = ");
	scanf("%lf", &z);
	printf("Result: %.3f\n", tan(sqrt(x)) + 165 * pow(z, 6) + pow(x*x - z, .25));
    return 0;
}
