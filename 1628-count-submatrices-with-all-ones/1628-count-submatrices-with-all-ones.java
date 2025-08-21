class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 2D array for heights
        int[][] height = new int[m][n];
        int total = 0;

        // Step 1: Build height matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i == 0) height[i][j] = 1;
                    else height[i][j] = height[i-1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }

        // Step 2: For each row, count rectangles ending at this row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minHeight = height[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, height[i][k]);
                    total += minHeight;
                }
            }
        }

        return total;
    }
}
