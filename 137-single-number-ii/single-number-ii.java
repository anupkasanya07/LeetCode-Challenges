class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate through all 32 bit positions
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            
            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitCount++;
                }
            }

            // If the count is not divisible by 3, set the i-th bit in result
            if (bitCount % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}