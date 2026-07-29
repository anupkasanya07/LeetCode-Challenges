import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Base boundary for the first valid substring
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // Push new base boundary
                    stack.push(i);
                } else {
                    // Calculate valid length from current index to top index in stack
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}