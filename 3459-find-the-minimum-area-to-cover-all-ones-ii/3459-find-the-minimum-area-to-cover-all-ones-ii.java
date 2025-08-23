class Solution {
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return divideGrid(grid, 3, 0, rows - 1, 0, cols - 1);
    }

    // divideGrid: current grid ko "parts" (kitne rectangles chahiye) me todta hai
    int divideGrid(int[][] grid, int parts, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) return 0;

        // Base case: agar sirf 1 rectangle chahiye, to rectangle ka minimum area nikal lo
        if (parts == 1) {
            return minRectangleArea(grid, top, bottom, left, right);
        }

        int ans = Integer.MAX_VALUE;

        // 1️⃣ Horizontal cuts (row ke basis par todna)
        for (int cutRow = top; cutRow <= bottom; cutRow++) {
            for (int firstPart = 1; firstPart < parts; firstPart++) {
                ans = Math.min(ans,
                        divideGrid(grid, firstPart, top, cutRow, left, right) +
                        divideGrid(grid, parts - firstPart, cutRow + 1, bottom, left, right));
            }
        }

        // 2️⃣ Vertical cuts (column ke basis par todna)
        for (int cutCol = left; cutCol <= right; cutCol++) {
            for (int firstPart = 1; firstPart < parts; firstPart++) {
                ans = Math.min(ans,
                        divideGrid(grid, firstPart, top, bottom, left, cutCol) +
                        divideGrid(grid, parts - firstPart, top, bottom, cutCol + 1, right));
            }
        }

        return ans;
    }

    // minRectangleArea: ek rectangle ka minimum bounding area return karta hai
    int minRectangleArea(int[][] grid, int top, int bottom, int left, int right) {
        int minCol = right;
        int maxCol = left;
        int minRow = bottom;
        int maxRow = top;
        boolean foundOne = false;

        for (int r = top; r <= bottom; r++) {
            for (int c = left; c <= right; c++) {
                if (grid[r][c] == 1) {
                    foundOne = true;
                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);
                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);
                }
            }
        }

        if (!foundOne) return 0; // agar 1 hi nahi mila, area = 0
        return (maxCol - minCol + 1) * (maxRow - minRow + 1);
    }
}
