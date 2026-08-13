class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // If the last seen position of charS and charT don't match, return false
            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Store current 1-based position (i + 1) to distinguish from default 0
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}