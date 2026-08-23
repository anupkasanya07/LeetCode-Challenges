class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is less than the next element,
            // the peak must be in the right half (excluding mid).
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // If mid element is greater than or equal to the next element,
            // the peak is either mid itself or in the left half.
            else {
                right = mid;
            }
        }

        // 'left' and 'right' converge to the index of a peak element.
        return left;
    }
}