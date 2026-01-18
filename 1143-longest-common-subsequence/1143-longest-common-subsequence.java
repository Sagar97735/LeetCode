class Solution {
     public int isSolve(String s1, String s2, int i, int j,Integer [][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1 + isSolve(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j] = Math.max(isSolve(s1,s2,i-1,j,dp), isSolve(s1,s2,i,j-1,dp));
        

    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer [][] dp = new Integer[text1.length()][text2.length()];
         return isSolve(text1,text2,text1.length()-1,text2.length()-1,dp);
        
    }
}