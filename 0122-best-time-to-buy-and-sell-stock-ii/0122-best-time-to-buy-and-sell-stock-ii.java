class Solution {

    public int solve(int[] prices, int i, int buy, Integer[][] dp) {

        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != null) {
            return dp[i][buy];
        }

        int skip = solve(prices, i + 1, buy, dp);
        int action;

        if (buy == 1) {
            // Buy
            action = -prices[i] + solve(prices, i + 1, 0, dp);
        } else {
            // Sell
            action = prices[i] + solve(prices, i + 1, 1, dp);
        }

        return dp[i][buy] = Math.max(skip, action);
    }

    public int maxProfit(int[] prices) {

        Integer[][] dp = new Integer[prices.length][2];

        return solve(prices, 0, 1, dp);
    }
}