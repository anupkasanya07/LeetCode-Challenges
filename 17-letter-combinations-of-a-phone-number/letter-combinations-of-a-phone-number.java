import java.util.ArrayList;
import java.util.List;

class Solution {
    // Phone keypad mapping
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base case: empty input string
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Goal: If we processed all digits, record the combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get matching letters for the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c);                          // Choose
            backtrack(digits, index + 1, current, result); // Explore
            current.deleteCharAt(current.length() - 1); // Un-choose (Backtrack)
        }
    }
}