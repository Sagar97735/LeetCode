// recursion based
// class Solution {

//     public int solve(String word1, String word2, int i, int j) {

//         // word1 empty
//         if(i == 0) {
//             return j;
//         }

//         // word2 empty
//         if(j == 0) {
//             return i;
//         }

//         // characters same
//         if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
//             return solve(word1, word2, i - 1, j - 1);
//         }

//         // replace
//         int replace = solve(word1, word2, i - 1, j - 1);

//         // delete
//         int delete = solve(word1, word2, i - 1, j);

//         // insert
//         int insert = solve(word1, word2, i, j - 1);

//         return 1 + Math.min(
//             replace,
//             Math.min(delete, insert)
//         );
//     }

//     public int minDistance(String word1, String word2) {
//         return solve(word1, word2, word1.length(), word2.length());
//     }
// }
class Solution {
    public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int [][] dp = new int[n+1][m+1];
    for(int i =0; i<=n; i++){
        dp[i][0] = i;
    }
    for(int i =0; i<=m; i++){
        dp[0][i] = i;
    }
    for(int i = 1; i<=n; i++){
        for(int j =1; j<=m; j++){
            if(word1.charAt(i-1)==word2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1];
            }
            else{
                dp[i][j] = 1+  Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
    }
    return dp[n][m];
    }
}