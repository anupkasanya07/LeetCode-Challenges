import java.util.*;

class Solution {
    // Memoization map to store results for subproblems (substring starting at index -> valid sentences)
    private Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a Set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet, 0);
    }

    private List<String> backtrack(String s, Set<String> wordSet, int start) {
        // Return cached result if already computed
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> results = new ArrayList<>();

        // Base case: reached the end of the string
        if (start == s.length()) {
            results.add("");
            return results;
        }

        // Try forming words starting from `start`
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            
            if (wordSet.contains(prefix)) {
                // Recursively break the remainder of the string
                List<String> subSentences = backtrack(s, wordSet, end);
                
                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        results.add(prefix);
                    } else {
                        results.add(prefix + " " + sub);
                    }
                }
            }
        }

        // Store in cache and return
        memo.put(start, results);
        return results;
    }
}