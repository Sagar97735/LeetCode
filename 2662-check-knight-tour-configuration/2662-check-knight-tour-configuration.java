class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false; // The knight must start at (0,0)
        return helper(grid, 0, 0, 0);
    }

    public boolean helper(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        // Base case
        if (grid[row][col] == n * n - 1) return true;
        int i, j;
        
        // 2 Up 1 Right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 2 Up 1 Left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 2 Down 1 Right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 2 Down 1 Left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 1 Up 2 Right
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 1 Up 2 Left
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 1 Down 2 Right
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        // 1 Down 2 Left
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1) return helper(grid, i, j, num + 1);

        return false;
    }
}
