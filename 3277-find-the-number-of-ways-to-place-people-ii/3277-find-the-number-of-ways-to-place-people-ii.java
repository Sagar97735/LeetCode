import java.util.Arrays;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Step 1: Sort by x ascending, and by y descending for equal x
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) return p1[0] - p2[0];
            return p2[1] - p1[1];
        });

        int count = 0;

        // Step 2: Fix each point as an "upper-left" corner candidate
        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];
            int leftX = points[i][0];

            // Use the smallest possible y so negative coordinates are handled correctly
            int lowerY = Integer.MIN_VALUE;

            // Step 3: Scan points to the right (j > i)
            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0], yj = points[j][1];

                // must be below or equal to the upper Y
                if (yj > upperY) continue;

                // must be to the right (xj >= leftX)
                if (xj < leftX) continue;

                // skip points that are not strictly below the last chosen lowerY
                if (yj <= lowerY) continue;

                // valid pair found
                count++;

                // update lower bound so next chosen point must be strictly below this y
                lowerY = yj;

                // move left boundary to the right of current x (prevents overlapping horizontally)
                leftX = xj + 1;
            }
        }
        return count;
    }
}
