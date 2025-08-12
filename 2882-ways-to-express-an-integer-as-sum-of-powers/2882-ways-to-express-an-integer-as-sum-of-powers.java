class Solution {
    public int numberOfWays(int n, int x) {
         int MOD = 1_000_000_007;
        // find max base such that base^x <= n
        int maxBase = 1;
        while (Math.pow(maxBase + 1, x) <= n) maxBase++;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int base = 1; base <= maxBase; base++) {
            int val = (int) Math.pow(base, x);
            for (int s = n; s >= val; s--) {
                dp[s] = (int) ((dp[s] + dp[s - val]) % MOD);
            }
        }
        return dp[n];
    }
}
