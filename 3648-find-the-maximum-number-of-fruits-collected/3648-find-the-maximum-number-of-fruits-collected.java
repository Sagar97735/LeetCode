class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        // Invalid region ko 0 kar rahe hai (jo dono diagonals ke beech me aate hai)
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if ((row < col && col < n - 1 - row) || (col < row && row < n - 1 - col)) {
                    fruits[row][col] = 0;
                }
            }
        }

        // First child collects along main diagonal (0,0) → (n-1,n-1)
        int diagonalFruits = 0;
        for (int i = 0; i < n; i++) {
            diagonalFruits += fruits[i][i];
        }

        // DP for second child (starts from top-left, ends at bottom-right)
        for (int row = 1; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                fruits[row][col] += Math.max(
                    fruits[row - 1][col - 1],
                    Math.max(
                        fruits[row - 1][col],
                        (col + 1 < n ? fruits[row - 1][col + 1] : 0)
                    )
                );
            }
        }

        // DP for third child (starts from top-left, ends at bottom-right)
        for (int col = 1; col < n; col++) {
            for (int row = col + 1; row < n; row++) {
                fruits[row][col] += Math.max(
                    fruits[row - 1][col - 1],
                    Math.max(
                        fruits[row][col - 1],
                        (row + 1 < n ? fruits[row + 1][col - 1] : 0)
                    )
                );
            }
        }

        // Add diagonal + best path for second + third child
        return diagonalFruits + fruits[n - 1][n - 2] + fruits[n - 2][n - 1];
    }
}
