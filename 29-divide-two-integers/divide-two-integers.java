class Solution {
    public int divide(int dividend, int divisor) {
        // Overflow edge case: Integer.MIN_VALUE / -1 = 2^31 (exceeds Integer.MAX_VALUE)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine result sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and work with positive values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Exponential subtraction using bit shifts
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Double the divisor as long as it fits inside absDividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            result += multiple;
        }

        return negative ? -result : result;
    }
}