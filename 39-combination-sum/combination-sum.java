import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort candidates to enable early loop termination
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Prune search space: if element exceeds remaining target, remaining elements will too
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            // Pass 'i' instead of 'i + 1' to allow reusing the same candidate
            backtrack(result, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}