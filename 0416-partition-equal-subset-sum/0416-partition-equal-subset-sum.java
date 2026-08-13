class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i<nums.length; i++){
          sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // Target = 0 is always possible
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // No elements -> cannot make positive target
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= nums.length; i++) {

            for (int j = 1; j <= target; j++) {

                if (nums[i - 1] > j) {

                    // Cannot take current element
                    dp[i][j] = dp[i - 1][j];

                } else {

                    // Take OR Not Take
                    dp[i][j] =
                        dp[i - 1][j] ||
                        dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];

    }
}