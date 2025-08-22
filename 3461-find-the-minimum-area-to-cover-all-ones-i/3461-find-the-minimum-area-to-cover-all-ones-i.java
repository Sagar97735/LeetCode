class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        if (maxRow == -1) return 0; // agar koi 1 nahi mila

        int l = maxRow - minRow + 1;
        int b = maxCol - minCol + 1;

        return l * b;
    }
}
