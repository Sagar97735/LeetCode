class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i =0;i<dp.length;i++){
          dp[i]= 1;
        }
        for(int i =1; i< dp.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i] && (dp[j]+1)>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}