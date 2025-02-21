//-----------------------------recursive approach<-----------------------------
// class Solution {
//     public void ispath(int[][] obstacleGrid , int m, int n,int i, int j, int[] arr){
//         if(i==m-1 && j==n-1){
//             arr[0] = 1+arr[0];
//             return;
//         }
//         if(i+1<m && obstacleGrid[i+1][j]==0){
//             ispath(obstacleGrid,m,n,i+1,j,arr);
//         }
//         if(j+1<n && obstacleGrid[i][j+1]==0){
//             ispath(obstacleGrid,m,n,i,j+1,arr);
//         }
//         return;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         if(obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
//             return 0;
//         }
//         int [] arr = new int[1];
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         ispath(obstacleGrid,m,n,0,0,arr);
//         return arr[0];
//     }
// }
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If starting or ending cell is blocked, no paths possible
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        
        int[][] dp = new int[m][n];

        // Initialize first cell
        dp[0][0] = 1;

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;  // No paths possible through obstacles
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j]; // From top
                    if (j > 0) dp[i][j] += dp[i][j - 1]; // From left
                }
            }
        }
        return dp[m - 1][n - 1]; // Bottom-right cell contains the answer
    }
}
