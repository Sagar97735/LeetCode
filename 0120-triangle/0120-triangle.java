class Solution {
     public int isSolve(List<List<Integer>>arr,int curr,int i,int[][] dp){
        if(i==arr.size()-1){
            return 0;
        }
        if(dp[curr][i]!=-1){
            return dp[curr][i];
        }
      int choice1 = arr.get(i+1).get(curr) + isSolve(arr,curr,i+1,dp);
      int choice2 = arr.get(i+1).get(curr+1)+ isSolve(arr,curr+1,i+1,dp);
       return dp[curr][i] = Math.min(choice1,choice2); 
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
         if (n == 1) {
        return triangle.get(0).get(0);
    }
        int [][] dp = new int[triangle.get(triangle.size()-1).size()+1][triangle.size()+1];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        isSolve(triangle,0,0,dp);
        return dp[0][0] + triangle.get(0).get(0);
       
    }
}