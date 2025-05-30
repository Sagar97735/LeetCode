class Solution {
    public int isSolve(int [][] grid,int i, int j,int m, int n,int [][]dp){
    if(i==m-1 && j == n-1){
        return grid[i][j];
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    if(i>=m){
          return 99999;
    }
    if(j>=n){
          return 99999;
    }
     int down = grid[i][j] + isSolve(grid,i+1,j,m,n,dp);
     int right = grid[i][j] + isSolve(grid,i,j+1,m,n,dp);
     return dp[i][j] = Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
          int [][] dp = new int[grid.length+1][grid[0].length+1];
            for(int [] arr:dp){
           Arrays.fill(arr,-1);
        }
        return isSolve(grid,0,0,grid.length,grid[0].length,dp);
    }
}