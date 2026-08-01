import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();

            // Find how many words fit in the current line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Case 1: Last line or line with only 1 word (Left Justified)
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                // Pad trailing spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: Fully Justified (Middle lines with > 1 words)
            else {
                int totalLetters = 0;
                for (int k = i; k < j; k++) {
                    totalLetters += words[k].length();
                }

                int totalSpaces = maxWidth - totalLetters;
                int spacesPerGap = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacesPerGap + (k - i < extraSpaces ? 1 : 0);
                        sb.append(" ".repeat(spacesToApply));
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next set of words
        }

        return result;
    }
}