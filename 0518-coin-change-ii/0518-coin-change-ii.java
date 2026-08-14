class Solution { 
    public int solve(int amount, int[] coins,int i,Integer [][] dp){
     if(amount==0){
        return 1;
     }
        if(i>=coins.length){
            return 0;
        }
       if(dp[amount][i]!=null){
        return dp[amount][i];
       }
        int c1 =0;
        int c2 =0;
        if(amount>=coins[i]){
         c1 = solve(amount-coins[i],coins,i,dp);
         c2 = solve(amount,coins,i+1,dp);
        }
        else{
            c2 = solve(amount,coins,i+1,dp);
        }
        return dp[amount][i] = c1+c2;
    }
    public int change(int amount, int[] coins) {
        Integer [][] dp = new Integer[amount+1][coins.length+1];
        return solve(amount,coins,0,dp);
    }
}