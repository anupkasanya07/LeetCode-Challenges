import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If exact target sum is found, return immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update closestSum if currentSum is closer to target
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}