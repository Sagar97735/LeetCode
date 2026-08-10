class Solution {
    public int solve(List<List<Integer>> triangle, int i, int j,Integer [][] dp){
        if(i>=triangle.size()){
            return 0;
        }
        if(j>=triangle.get(i).size()){
            return Integer.MAX_VALUE-10000;
        }
         if(dp[i][j]!= null){
            return dp[i][j];
         }
        int c1 = triangle.get(i).get(j) + solve(triangle,i+1,j,dp);
        int c2 = triangle.get(i).get(j) + solve(triangle,i+1,j+1,dp);
        return dp[i][j] = Math.min(c1,c2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()+1][triangle.size()+1];
        return solve(triangle,0,0,dp);
    }
}