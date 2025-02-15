import java.util.Arrays;

class Solution {
    public boolean solve(int[][] dp, int i, int j, int k, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean result = false;

        if (i < s1.length() && j < s2.length() && s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) {
            result = solve(dp, i + 1, j, k + 1, s1, s2, s3) || solve(dp, i, j + 1, k + 1, s1, s2, s3);
        } else if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            result = solve(dp, i + 1, j, k + 1, s1, s2, s3);
        } else if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            result = solve(dp, i, j + 1, k + 1, s1, s2, s3);
        }

        dp[i][j] = result ? 1 : 0; // Store the result in memoization table
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(dp, 0, 0, 0, s1, s2, s3);
    }
}
