class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length +1 ][grid[0].length+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(grid, 0, 0, dp);
    }
    public int solve(int grid[][], int i, int j, int dp[][]){
        //Base condition
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i >= grid.length || j >= grid[0].length){
            return 99999;
        }

        int down = grid[i][j] + solve(grid, i+1, j,dp);
        int right = grid[i][j] + solve(grid, i, j+1,dp);
        return dp[i][j] = Math.min(down, right);
    }
}