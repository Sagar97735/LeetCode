class Solution {
      public int isSolve(int [] cost,int i,int [] dp){
        if(i>=cost.length){
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int jumpby1 = cost[i] + isSolve(cost,i+1,dp);
        int jumpby2 = cost[i] + isSolve(cost,i+2,dp);
        return dp[i] = Math.min(jumpby1,jumpby2);
        
    }
    public int minCostClimbingStairs(int[] cost) {
          int [] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(isSolve(cost,0,dp),isSolve(cost,1,dp));
    }
}