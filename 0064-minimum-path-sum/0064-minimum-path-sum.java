class Solution {
    public int solve(int [][] nums, int i, int j,Integer [][] dp){
       if(i==nums.length-1 && j== nums[0].length-1){
        return nums[i][j];
       }
       if(i>=nums.length || j>= nums[0].length){
        return Integer.MAX_VALUE-10000;
       }
    if(dp[i][j]!=null){
        return dp[i][j];

    }
        int c1 = nums[i][j] + solve(nums,i+1,j,dp);
        int c2 = nums[i][j] + solve(nums,i,j+1,dp);
        return dp[i][j]= Math.min(c1,c2);
    }
    public int minPathSum(int[][] grid) {
        Integer [][] dp = new Integer[grid.length+1][grid[0].length+1];
        return solve(grid,0,0,dp);
    }
}