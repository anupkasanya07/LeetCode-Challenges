import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // Quick length check
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int start, int dots, String current, List<String> result) {
        // Base case: exactly 4 segments formed
        if (dots == 4) {
            if (start == s.length()) {
                result.add(current.substring(0, current.length() - 1)); // Remove trailing dot
            }
            return;
        }

        // Explore segments of length 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) {
                break;
            }

            String part = s.substring(start, start + len);

            // Check leading zero rule and range <= 255
            if ((part.startsWith("0") && len > 1) || (len == 3 && Integer.parseInt(part) > 255)) {
                continue;
            }

            backtrack(s, start + len, dots + 1, current + part + ".", result);
        }
    }
}