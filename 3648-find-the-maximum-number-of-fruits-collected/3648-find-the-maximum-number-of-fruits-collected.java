class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        // Step 1: Mark cells inaccessible to all 3 children as 0 (pruning the grid)
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if ((row < col && col < n - 1 - row) || (col < row && row < n - 1 - col)) {
                    fruits[row][col] = 0;
                }
            }
        }

        // Step 2: First child - collect fruits along the main diagonal (from (0, 0) to (n-1, n-1))
        int totalFruits = 0;
        for (int i = 0; i < n; ++i) {
            totalFruits += fruits[i][i];
        }

        // Step 3: Second child - starts from (0, n-1) and moves down-left
        for (int row = 1; row < n; ++row) {
            for (int col = row + 1; col < n; ++col) {
                fruits[row][col] += Math.max(
                    fruits[row - 1][col],                           // down
                    Math.max(
                        fruits[row - 1][col - 1],                  // down-left
                        (col + 1 < n) ? fruits[row - 1][col + 1] : 0 // down-right
                    )
                );
            }
        }

        // Step 4: Third child - starts from (n-1, 0) and moves up-right
        for (int col = 1; col < n; ++col) {
            for (int row = col + 1; row < n; ++row) {
                fruits[row][col] += Math.max(
                    fruits[row][col - 1],                          // right
                    Math.max(
                        fruits[row - 1][col - 1],                 // up-right
                        (row + 1 < n) ? fruits[row + 1][col - 1] : 0 // down-right
                    )
                );
            }
        }

        // Final answer includes:
        // - fruits collected by first child (main diagonal)
        // - best path end points for second and third children
        totalFruits += fruits[n - 1][n - 2]; // end of second child's path
        totalFruits += fruits[n - 2][n - 1]; // end of third child's path

        return totalFruits;
    }
}
