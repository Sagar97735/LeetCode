class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i< nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return false;
        }
        sum = sum/2;
        int dp[][] = new int[nums.length+1][sum+1];
        for(int i = 0; i<=nums.length; i++){
           for(int j =0; j<sum+1;j++){
            if(i==0||j==0){
                dp[i][j]=0;
            }
           }
        }
        for(int i =1; i<nums.length+1;i++){
            for(int j =1; j<sum+1; j++){
              if(nums[i-1]<=j){//include
                 int ans1 = nums[i-1]+dp[i-1][j-nums[i-1]];
                 int ans2 = dp[i-1][j];
                 dp[i][j] = Math.max(ans1,ans2);
              }
              else{
                dp[i][j]=dp[i-1][j];
              }
            }
        }
        if(dp[nums.length][sum]== sum){
            return true;
        }
        return false;
    }
}