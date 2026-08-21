class Solution {
    public int solve(int[] prices, int i,int buy,Integer [][]dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy]!=null){
            return dp[i][buy];
        }
        int c1 =0;
        int c2 =0;
           c1 = solve(prices,i+1,buy,dp);
        if(buy==0){
          c2 = -prices[i] + solve(prices,i+1,1,dp);
        }
        else if(buy==1){
             c2 = prices[i] + solve(prices,i+2,0,dp);
        }
        return dp[i][buy] = Math.max(c1,c2);
    }
    public int maxProfit(int[] prices) {
        Integer [][] dp = new Integer[prices.length+1][2];
        return solve(prices,0,0,dp);
        
    }
}