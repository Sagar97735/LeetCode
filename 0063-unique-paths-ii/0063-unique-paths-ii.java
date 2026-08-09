class Solution {
    public int solve(int[][] arr, int i, int j,Integer[][] dp){
         if(i>=arr.length && j >= arr[0].length){
            return 0;
        }
        if(i==arr.length-1 && j ==arr[0].length-1 && arr[i][j]!=1){
            return 1;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
       
        int c1 = 0;
        int c2 = 0;
        if(j+1<arr[0].length && arr[i][j+1]!=1){
            c1 = solve(arr,i,j+1,dp);
        }
        if(i+1<arr.length && arr[i+1][j]!=1){
            c2 = solve(arr,i+1,j,dp);
        }
        return dp[i][j] = c1+c2;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        Integer[][] dp = new Integer[obstacleGrid.length+1][obstacleGrid[0].length+1];
        return solve(obstacleGrid,0,0,dp);
    }
}