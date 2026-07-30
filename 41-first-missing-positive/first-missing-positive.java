class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each positive integer x (1 <= x <= n) at index x - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int targetIndex = nums[i] - 1;
                // Swap nums[i] and nums[targetIndex]
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }
        
        // Find the first index where the number doesn't match index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all 1..n are present, missing number is n + 1
        return n + 1;
    }
}