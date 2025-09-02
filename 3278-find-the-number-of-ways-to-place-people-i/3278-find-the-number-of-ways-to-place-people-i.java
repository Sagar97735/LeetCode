class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return Integer.signum(point2[1] - point1[1]);
            } else {
                return Integer.signum(point1[0] - point2[0]);
            }
        });
        int countOfPairs = 0;
        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];
            int leftX = points[i][0];
            int lowerY = -50;
            for (int j = i + 1; j < n; j++) {
                if (points[j][1] > upperY)
                    continue;
                if (points[j][0] < leftX)
                    continue;
                if (points[j][1] <= lowerY)
                    continue;
                countOfPairs++;
                lowerY = points[j][1];
                leftX = points[j][0] + 1;
            }
        }
        return countOfPairs;
    }
}