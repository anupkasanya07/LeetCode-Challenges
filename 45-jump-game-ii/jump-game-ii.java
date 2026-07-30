class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // We don't need to iterate over the last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // Must take a jump when reaching the boundary of current range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Stop early if we can already reach the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}