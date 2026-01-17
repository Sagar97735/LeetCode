class Solution {
    public boolean find(int [] nums,int req,int sum,int i, Boolean [][] dp){
        if(sum==req){
            return true;
        }
        if(i>=nums.length || sum>req){
            return false;
        }
        if(dp[sum][i]!=null){
            return dp[sum][i];
        }
        boolean b1 = find(nums,req,sum+nums[i],i+1,dp);
        boolean b2 = find(nums,req,sum,i+1,dp);
        return dp[sum][i] = b1 || b2;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i =0; i<nums.length; i++){
          sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int req = sum/2;
        Boolean [][] dp = new Boolean[req+1][nums.length+1];
        return find(nums,req,0,0,dp);
    }
}