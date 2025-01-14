class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1){
            return s;
        }
        int max = 1;
        String x = "";
        String y = "";
        int[][] dp = new int[n][n];
        for(int i =0; i<n; i++){
         dp[i][i] = 1;
        }
        //we have to traverse diagonally
        for(int j =1; j<n; j++){
         for(int i =0; i<j; i++){
         if(s.charAt(i)!=s.charAt(j)){
          dp[i][j] = 0;
         }
          if(s.charAt(i)==s.charAt(j) && j-i==1){
               dp[i][j] =2;
                if(dp[i][j]>max){
                max = dp[i][j];
                x = "";
                y = "";
                x+=i;
                y+=j;
            }
         }
         else if(s.charAt(i)==s.charAt(j) && j-i>1){
          if(dp[i+1][j-1]>0){
            dp[i][j]=2+dp[i+1][j-1];
            if(dp[i][j]>max){
                max = dp[i][j];
                x = "";
                y = "";
                x+=i;
                y+=j;
            }
          }
          else{
            dp[i][j] = 0;
          }
         }

        }
        }
        String ans = "";
        
       if(x.length()>0 && y.length()>0) {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        for(int i =a; i<=b;i++){
         ans+=s.charAt(i);
        }
        return ans;
       }
        return String.valueOf(s.charAt(0));
    }
}