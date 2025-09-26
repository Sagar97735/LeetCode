class Solution {
    public void solve(int row, int col, int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i<n; i++){
            matrix[row][i] = 0;
        }
        for(int i =0; i<m; i++){
            matrix[i][col] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean [][] arr = new boolean[m][n];
          for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(matrix[i][j]==0){
                    arr[i][j] = true;
                }
            }
        }
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(matrix[i][j]==0 && arr[i][j]==true){
                    solve(i,j,matrix);
                }
            }
        }
    }
}