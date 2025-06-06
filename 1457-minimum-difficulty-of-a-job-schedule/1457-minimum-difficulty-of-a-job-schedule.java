class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) {
            return -1;
        }
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(jobDifficulty, len, 0, d);
    }
    int[][] dp = new int[301][11];
    private int solve(int[] jobDifficulty, int len, int index, int d) {
        if (d == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = index; i < len; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        if (dp[index][d] != -1) {
            return dp[index][d];
        }
        int max = Integer.MIN_VALUE;
        int minResult = Integer.MAX_VALUE;
        for (int i = index; i <= len - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            int jobsMax = max + solve(jobDifficulty, len, i + 1, d - 1);
            minResult = Math.min(minResult, jobsMax);
        }
        dp[index][d] = minResult;
        return minResult;
    }
}