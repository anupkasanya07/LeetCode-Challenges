import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<Double, Integer> slopeMap = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                double slope;
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0) {
                    slope = Double.POSITIVE_INFINITY; // Vertical line
                } else if (dy == 0) {
                    slope = 0.0; // Horizontal line (avoids -0.0)
                } else {
                    slope = (double) dy / dx;
                }

                // Increment slope count
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                
                // Update global maximum (+1 to include the base point i)
                maxPoints = Math.max(maxPoints, slopeMap.get(slope) + 1);
            }
        }

        return maxPoints;
    }
}