class Solution {
    public void solve(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j = i; j<n; j++){
                solve(matrix,i,j);
            }
        }
        for(int i = 0; i<matrix.length; i++){
            for(int j =0; j<(n/2); j++){
                int temp = matrix[i][j];
             matrix[i][j] = matrix[i][n-j-1];
             matrix[i][n-j-1] = temp;
            }
        }
    }
}