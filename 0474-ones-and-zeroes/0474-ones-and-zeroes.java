class Solution {
    public int solve(String[] str, int zeros, int ones, int m, int n, int i, int[][][] dp) {

        if (zeros > m || ones > n)
            return Integer.MIN_VALUE; // invalid

        if (i == str.length)
            return 0;

        if (dp[i][zeros][ones] != -1)
            return dp[i][zeros][ones];

        int zero = 0, one = 0;
        for (char c : str[i].toCharArray()) {
            if (c == '0') zero++;
            else one++;
        }

        // include the current string
        int take = 1 + solve(str, zeros + zero, ones + one, m, n, i + 1, dp);

        // exclude the current string
        int skip = solve(str, zeros, ones, m, n, i + 1, dp);

        return dp[i][zeros][ones] = Math.max(take, skip);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++)
            for (int j = 0; j <= m; j++)
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = -1;

        return solve(strs, 0, 0, m, n, 0, dp);
    }
}
