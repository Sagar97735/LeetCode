class Solution {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for (int x : nums) total += x;

        long[] dp = new long[n+1];
        Arrays.fill(dp, Long.MAX_VALUE/2);
        dp[0] = 0;

        HashMap<Integer, Long> best = new HashMap<>();
        best.put(0, 0L);

        long prefix = 0;
        for (int i = 1; i <= n; i++) {
            prefix += nums[i-1];
            int mod = (int)(prefix % k);

            dp[i] = dp[i-1] + nums[i-1];  // default case

            if (best.containsKey(mod)) {
                dp[i] = Math.min(dp[i], best.get(mod));
            }

            best.put(mod, Math.min(best.getOrDefault(mod, Long.MAX_VALUE/2), dp[i]));
        }

        return dp[n];
    }
}
