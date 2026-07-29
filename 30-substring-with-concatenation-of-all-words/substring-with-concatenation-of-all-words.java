import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Count frequencies of words in target array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try every possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i;
            int count = 0;

            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);

                if (wordCount.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;

                    // Shrink window if word frequency exceeds limit
                    while (seen.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Valid match found
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word reset window
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}