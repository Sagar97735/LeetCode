class Solution {
    public int solve(int[] prices, int fee, int i,int buy,Integer[][] dp){
   if(i>=prices.length){
    return 0;
   }
    int c2 = 0;
    int c1 = 0;
    if(dp[i][buy]!=null){
        return dp[i][buy];
    }
    c1 = solve(prices,fee,i+1,buy,dp);
    if(buy==0){
        c2 = -prices[i] + solve(prices,fee,i+1,1,dp);
    }
    else{
        c2 = prices[i] -fee + solve(prices,fee,i+1,0,dp);
    }
    return dp[i][buy] = Math.max(c1,c2);
}
    public int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length+1][2];
        return solve(prices,fee,0,0,dp);
    }
}