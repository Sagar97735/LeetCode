class Solution {

    public int solve(String s, String t, int i, int j, int[][] dp) {

        // t is completely formed
        if (j == t.length()) {
            return 1;
        }

        // s is finished but t is still remaining
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int c1 = 0;

        if (s.charAt(i) == t.charAt(j)) {

            // Take s[i]
            c1 = solve(s, t, i + 1, j + 1, dp);
        }

        // Skip s[i]
        int c2 = solve(s, t, i + 1, j, dp);

        return dp[i][j] = c1 + c2;
    }

    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(s, t, 0, 0, dp);
    }
}