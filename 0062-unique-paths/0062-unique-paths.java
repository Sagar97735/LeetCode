//------------------------------>Recursive approach<---------------------------
// class Solution {
//     public void ispath(int m, int n,int i, int j,int[] arr){
//       if(i==m-1 && j==n-1){
//         arr[0] = arr[0]+1;
//         return;
//       }
//       if(i+1<m){
//          ispath(m,n,i+1,j,arr); 
//       }
//       if(j+1<n){
//         ispath(m,n,i,j+1,arr);
//       }
//       return;
//     }
//     public int uniquePaths(int m, int n) {
//     int [] arr = new int[1];
//     ispath(m,n,0,0,arr);
//     return arr[0];
//     }
// }
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}