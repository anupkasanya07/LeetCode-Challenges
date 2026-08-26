public class Solution {
    // Time Complexity: O(k) where k is the number of set bits (at most 32)
    // Space Complexity: O(1)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clears the lowest set bit
            count++;
        }
        return count;
    }
}