class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int totalSquares = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // agar 0 hai to koi square nhi banega
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        // first row ya first column me ho -> sirf 1x1 square banega
                        dp[i][j] = 1;
                    } else {
                        // otherwise formula lagao
                        dp[i][j] = 1 + Math.min(
                                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                                        dp[i - 1][j - 1]);
                    }
                }
                // jitna bada square yaha ban raha hai utne hi squares contribute karega
                totalSquares += dp[i][j];
            }
        }
        return totalSquares;
    }
}
