import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // bottom-left diagonals (including main diagonal)
        for (int i = 0; i < n; i++) {
            processDiagonal(grid, i, 0, false); // descending
        }

        // top-right diagonals
        for (int j = 1; j < n; j++) {
            processDiagonal(grid, 0, j, true); // ascending
        }

        return grid;
    }

    private void processDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> diag = new ArrayList<>();

        // collect
        int i = row, j = col;
        while (i < n && j < n) {
            diag.add(grid[i][j]);
            i++; j++;
        }

        // sort
        if (ascending) Collections.sort(diag);
        else diag.sort(Collections.reverseOrder());

        // put back
        i = row; j = col;
        for (int val : diag) {
            grid[i][j] = val;
            i++; j++;
        }
    }
}

