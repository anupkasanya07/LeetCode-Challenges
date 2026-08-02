class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Count frequencies of characters in t
        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }
        
        // Count unique characters needed
        int required = 0;
        for (int count : targetCount) {
            if (count > 0) required++;
        }
        
        int[] windowCount = new int[128];
        int formed = 0;
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            // Add current character to window
            char c = s.charAt(right);
            windowCount[c]++;
            
            // Check if frequency matches requirement
            if (targetCount[c] > 0 && windowCount[c] == targetCount[c]) {
                formed++;
            }
            
            // Try to shrink window from the left while it remains valid
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                
                // Update minimal window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                // Remove character at left pointer
                windowCount[leftChar]--;
                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}