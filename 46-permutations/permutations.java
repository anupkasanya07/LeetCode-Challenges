import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: if current permutation length equals array length, add to result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            // Skip elements that are already used in the current path
            if (current.contains(num)) {
                continue;
            }

            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}