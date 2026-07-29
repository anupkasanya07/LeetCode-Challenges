class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Target lies in the left half
                } else {
                    low = mid + 1;  // Target lies in the right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Target lies in the right half
                } else {
                    high = mid - 1; // Target lies in the left half
                }
            }
        }

        return -1; // Target not found
    }
}