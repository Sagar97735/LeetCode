class Solution {
    public void solve(int[][] grid){
        for(int i =grid.length-1; i>=0; i--){
            for(int j =grid.length-1; j>=0; j--){
                if(i==j || i>j){
                    if(i!=0 &&j!=0 && grid[i-1][j-1]<grid[i][j]){
                        int a = grid[i][j];
                        grid[i][j] = grid[i-1][j-1];
                        grid[i-1][j-1]=a;
                    }
                }
                if(i<j && i!=0 && j!=0){
                     if(grid[i-1][j-1]>grid[i][j]){
                        int a = grid[i][j];
                        grid[i][j] = grid[i-1][j-1];
                        grid[i-1][j-1]=a;
                    }
                }
            }
        }
        return;
    }
    public int[][] sortMatrix(int[][] grid) {
        for(int i =0; i<grid.length-1; i++){
            solve(grid);
        }
        return grid;
    }
}