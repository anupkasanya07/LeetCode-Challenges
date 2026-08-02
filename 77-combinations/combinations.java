import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning: only iterate up to where enough elements remain
        int maxStart = n - (k - current.size()) + 1;
        for (int i = start; i <= maxStart; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}