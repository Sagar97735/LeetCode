class Solution {

    int rows;
    int cols;
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        dp = new Integer[rows][cols][cols];

        return solve(grid, 0, 0, cols - 1);
    }

    private int solve(int[][] grid, int i, int j1, int j2) {

        // Base case: last row
        if (i == rows - 1) {

            if (j1 == j2) {
                return grid[i][j1];
            }

            return grid[i][j1] + grid[i][j2];
        }

        // Already calculated
        if (dp[i][j1][j2] != null) {
            return dp[i][j1][j2];
        }

        // Cherries collected at current row
        int cherries = grid[i][j1];

        if (j1 != j2) {
            cherries += grid[i][j2];
        }

        int max = 0;

        // Robot 1 movement
        for (int d1 = -1; d1 <= 1; d1++) {

            // Robot 2 movement
            for (int d2 = -1; d2 <= 1; d2++) {

                int newJ1 = j1 + d1;
                int newJ2 = j2 + d2;

                // Check boundaries
                if (newJ1 >= 0 && newJ1 < cols &&
                    newJ2 >= 0 && newJ2 < cols) {

                    max = Math.max(
                        max,
                        solve(grid, i + 1, newJ1, newJ2)
                    );
                }
            }
        }

        return dp[i][j1][j2] = cherries + max;
    }
}