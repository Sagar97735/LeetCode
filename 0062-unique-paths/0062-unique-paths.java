class Solution {
    public int solve(Integer [][] arr , int i, int j){
       if(i>=arr.length || j>=arr[0].length){
        return 0;
       }
       if(arr[i][j]!=null){
        return arr[i][j];
       }
       if(i==arr.length-1 && j==arr[0].length-1){
        return 1;
       }
      int c1 = solve(arr,i+1,j);
      int c2 = solve(arr,i,j+1);
      return arr[i][j] = c1+c2;
    }
    public int uniquePaths(int m, int n) {
        Integer [][] arr = new Integer[m][n];
        return solve(arr,0,0);
    }
}