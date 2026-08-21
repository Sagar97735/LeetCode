class Solution {
    public int solve(int[] prices, int i,int buy, int cnt,Integer [][][]dp){
        if(i>=prices.length || cnt>2){
            return 0;
        }
        if(dp[i][buy][cnt]!=null){
            return dp[i][buy][cnt];
        }
        int c1 =0;
        int c2 =0;
           c1 = solve(prices,i+1,buy,cnt,dp);
        if(buy==0){
          c2 = -prices[i] + solve(prices,i+1,1,cnt+1,dp);
        }
        else if(buy==1){
             c2 = prices[i] + solve(prices,i+1,0,cnt,dp);
        }
        return dp[i][buy][cnt] = Math.max(c1,c2);
    }
    public int maxProfit(int[] prices) {
        Integer [][][] dp = new Integer[prices.length+1][2][3];
    return solve(prices,0,0,0,dp);

    }
}