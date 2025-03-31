class Solution {
    public void isSolve(char[][] grid, boolean[][] visit, int i, int j){
        // Base case: Check out of bounds, water ('0'), or already visited
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visit[i][j]) {
            return;
        }

        // Mark as visited
        visit[i][j] = true;

        // Explore all four directions
        isSolve(grid, visit, i + 1, j);  // Down
        isSolve(grid, visit, i - 1, j);  // Up
        isSolve(grid, visit, i, j + 1);  // Right
        isSolve(grid, visit, i, j - 1);  // Left
    }
    public int numIslands(char[][] grid) {
    boolean[][] visit = new boolean [grid.length][grid[0].length];
    int cnt = 0;
    for(int i =0; i<grid.length; i++){
        for(int j =0; j<grid[0].length; j++){
            if(grid[i][j]=='1' && visit[i][j]==false){
                 isSolve(grid,visit,i,j);
                 cnt++;
            }
        }
    }
   return cnt;
    }
}