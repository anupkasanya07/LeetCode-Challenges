import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        
        // Compute factorials and populate available numbers
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        StringBuilder sb = new StringBuilder();

        // Determine each digit position by position
        for (int i = 1; i <= n; i++) {
            int blockFactorial = factorial[n - i];
            int index = k / blockFactorial;

            sb.append(numbers.get(index));
            numbers.remove(index); // Remove chosen number

            k %= blockFactorial; // Update k for the remaining positions
        }

        return sb.toString();
    }
}