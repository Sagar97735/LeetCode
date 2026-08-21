// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         int[][] dp = new int[n+1][m+1];

//         for(int i=0;i<=n;i++) Arrays.fill(dp[i], -1);

//         return helper(n, m, s, p, dp);
//     }

//     private boolean helper(int i, int j, String s, String p, int[][] dp){
//         if(i==0 && j==0) return true;
//         if(i>0 && j==0) return false;
//         if(i==0 && j>0) return check(j, p);

//         if(dp[i][j] != -1) return dp[i][j]==1;
//         boolean ans = false;

//         if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
//             ans = helper(i-1, j-1, s, p, dp);
//         }
//         else if(p.charAt(j-1) == '*'){
//             ans = helper(i, j-1, s, p, dp) || helper(i-1, j, s, p, dp);
//         }

//         dp[i][j] = ans ? 1 : 0;

//         return ans;
//     }

//     private boolean check(int j, String p){
//         for(int i=0;i<j;i++){
//             if(p.charAt(i) != '*') return false;
//         }

//         return true;
//     }
// }
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i=1;i<=m;i++){
            dp[0][i] = check(i, p);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                boolean ans = false;

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    ans = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    ans = dp[i][j-1] || dp[i-1][j];
                }

                dp[i][j] = ans;
            }
        }

        return dp[n][m];
    }

    private boolean check(int j, String p){
        for(int i=0;i<j;i++){
            if(p.charAt(i) != '*') return false;
        }

        return true;
    }
}