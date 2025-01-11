class Solution {
    public int findTargetSumWays(int[] nums, int target) { 
       int sum = 0;
       int diff = target;
       target = Math.abs(target);
       for(int i =0; i<nums.length; i++){
           sum+= nums[i];
       }
       
       int netsum = sum+diff;
       if(netsum%2!=0||target>sum){
        return 0;
       }
       netsum = netsum/2;
       netsum = Math.abs(netsum);
    int [][] dp = new int[nums.length+1][netsum+1];
    dp[0][0]=1;
     for(int i =1; i<netsum+1; i++){
        dp[0][i]=0;
    }
      for(int i =1; i<nums.length+1; i++){
        for(int j =0; j<netsum+1; j++){
          if(nums[i-1]<=j){
            dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    //(exclude)     (include)
          }
          else{
            dp[i][j] = dp[i-1][j];
          }
        }
    }
   
    return dp[nums.length][netsum];
    }
}