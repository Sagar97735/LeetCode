class Solution {
    public void isSolve(int [] coins, int [][] dp){
        
      for(int i =1; i<dp.length; i++){
        for(int j =1; j<dp[0].length; j++){
            if(coins[i-1]<=j){
                      dp[i][j] = Math.min(dp[i-1][j],1+ dp[i][j-coins[i-1]]);
                }
            
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
      }
      return;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount ==0){
            return 0;
        }
        int n = coins.length;
        int [][] dp = new int[coins.length+1][amount+1];
        Arrays.sort(coins);
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) dp[i][j] = 0; // 0 coins to make 0 amount
                else dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }

       
        isSolve(coins,dp);
         return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }
}