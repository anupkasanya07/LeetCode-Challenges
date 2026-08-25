public class Solution {
    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left by 1 to make space for the next bit
            result <<= 1;
            // Append the least significant bit (LSB) of n to result
            result |= (n & 1);
            // Shift n right by 1 using unsigned right shift (>>>)
            n >>>= 1;
        }
        return result;
    }
}