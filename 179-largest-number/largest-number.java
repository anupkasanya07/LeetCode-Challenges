import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert int array to String array
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort strings using custom comparator
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle edge case where the largest number is "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // Step 4: Concatenate all strings to form the largest number
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}