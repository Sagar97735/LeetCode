class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = number of people who learn secret on day i
        dp[1] = 1; // Day 1 par ek aadmi ko secret maloom hai

        for (int i = 2; i <= n; i++) { // current day i
            for (int j = Math.max(1, i - forget + 1); j <= i - delay; j++) {
                dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }

        long ans = 0;
        // un logon ko count karo jo abhi tak nahi bhule (day n ke end par)
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return (int) ans;
    }
}
