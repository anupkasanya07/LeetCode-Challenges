class Solution {
    public double myPow(double x, int n) {
        long N = n; // Cast to long to handle Integer.MIN_VALUE overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            // If N is odd, multiply the current power into the result
            if ((N % 2) == 1) {
                result *= currentProduct;
            }
            // Square the base and halve the exponent
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
}