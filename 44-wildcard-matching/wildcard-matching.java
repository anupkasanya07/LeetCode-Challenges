class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;
        
        int sLen = s.length();
        int pLen = p.length();

        while (sIdx < sLen) {
            // Case 1: Exact character match or '?' wild card
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: '*' found, record its location and assume it matches 0 characters for now
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            } 
            // Case 3: Mismatch, but we saw a '*' before -> Backtrack to let '*' match one more char
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            } 
            // Case 4: Mismatch and no '*' to backtrack to
            else {
                return false;
            }
        }

        // Consume remaining '*' in pattern
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }
}