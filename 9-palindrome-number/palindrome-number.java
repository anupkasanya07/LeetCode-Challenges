class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes.
        // 2. If the last digit is 0, the first digit must also be 0 (only '0' satisfies this).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers: x == reversedNumber (e.g., 1221 -> 12 == 12)
        // For odd-length numbers: x == reversedNumber / 10 (e.g., 121 -> 1 == 12/10)
        return x == reversedNumber || x == reversedNumber / 10;
    }
}