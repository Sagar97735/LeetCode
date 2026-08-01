class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxV = 0;
        for (int x : nums) maxV = Math.max(maxV, x);

        // cnt[v] = how many times v appears
        long[] cnt = new long[maxV + 1];
        for (int x : nums) cnt[x]++;

        // pre[v] = how many elements are <= v
        long[] pre = new long[maxV + 2];
        for (int v = 1; v <= maxV; v++) pre[v] = pre[v - 1] + cnt[v];

        long ans = 0;
        for (int d = 1; d <= maxV; d++) {          // d = divisor value
            if (cnt[d] == 0) continue;
            for (int k = 1; (long) k * d <= maxV; k++) {
                int lo = k * d;                     // numerators giving quotient k
                int hi = Math.min(maxV, lo + d - 1);
                long inRange = pre[hi] - pre[lo - 1];
                if (inRange == 0) continue;
                ans = (ans + inRange % MOD * k % MOD * (cnt[d] % MOD)) % MOD;
            }
        }
        return (int) ans;
    }
}