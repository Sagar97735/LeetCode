class Solution {
    public int solve(int[] coins, int amount,int i, Integer [][] dp ){
         if(amount==0){
        return 0;
       }
       if(i>=coins.length){
        return Integer.MAX_VALUE-1000;
       }
       if(dp[i][amount]!=null){
        return dp[i][amount];
       }
        int c1 = Integer.MAX_VALUE - 1000;
        int c2 = Integer.MAX_VALUE - 1000;
       if(amount>=coins[i]){
        c1 = 1+solve(coins,amount-coins[i],i,dp);
       }
      
         c2 = solve(coins,amount,i+1,dp);
        
       return dp[i][amount] = Math.min(c1,c2);
    }
    public int coinChange(int[] coins, int amount) {
        Integer [][] dp = new Integer[coins.length+1][amount+1];
         int ans = solve(coins, amount, 0,dp);

        if (ans >= Integer.MAX_VALUE - 1000) {
            return -1;
        }
        return ans;
    }
}