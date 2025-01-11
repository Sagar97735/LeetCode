class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int [n+1][amount+1];  // making dp array with size of coins array and amount
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;   // When amount is 0 then 0 coins are required 
        }
        for(int i = 0; i <= amount ; i++){
            dp[0][i] = Integer.MAX_VALUE - 1; //When there is 0 coins then amount can't be made 
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){ // if coin at i-1th position is less than or equal to amount
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);  
                }
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }
        return dp[n][amount] != Integer.MAX_VALUE - 1 ? dp[n][amount] : -1;
    }}