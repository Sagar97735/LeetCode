class Solution {
    public int solve(int [] nums, int i,Integer [] dp){
        if(i>=nums.length){
            return 0;
        }
          if(dp[i]!=null){
            return dp[i];
          }
        int c1 = nums[i]+solve(nums,i+2,dp);
        int c2 = solve(nums,i+1,dp);
        return dp[i] = Math.max(c1,c2);
    }
    public int rob(int[] nums) {
        Integer [] dp = new Integer[nums.length];
        
      return solve(nums,0,dp);
    }
}