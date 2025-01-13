class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = "";
        for(int i = s1.length()-1; i>=0;i--){
            s2+=s1.charAt(i);
        }
       int m = s1.length();
       int n = s2.length();
       int [][] dp = new int[m+1][n+1];
       for(int i =1; i<m+1; i++){
        for(int j =1; j<n+1; j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
       }
       return dp[m][n];
    //    String ans = "";
    //    int i = m;
    //    int j = n; 
    //    while(i>0&&j>0){
    //     if(s1.charAt(i-1)==s2.charAt(j-1)){
    //         ans+=s1.charAt(i-1);
    //         i--;
    //         j--;
    //     }
    //     else if(dp[i-1][j]>dp[i][j-1]){
    //         i--;
    //     }
    //     else{
    //         j--;
    //     }
    //    }
    //    return ans.length();
    }
}