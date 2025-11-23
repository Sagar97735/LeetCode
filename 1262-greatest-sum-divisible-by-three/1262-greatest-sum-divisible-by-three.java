class Solution {
    public int maxSumDivThree(int[] nums) {

        int[] dp = new int[3];
        Arrays.fill(dp, 0);

        for (int num : nums) {
            int[] newdp = dp.clone();
            for (int r = 0; r < 3; r++) {
                int newSum = dp[r] + num;
                int rem = newSum % 3;
                newdp[rem] = Math.max(newdp[rem], newSum);
            }
            dp = newdp;
        }

        return dp[0];
    }
}
