class Solution {
    public boolean isSolve1(int[][] heights, int i, int j, boolean[][] visited) {
        if (i == 0 || j == 0) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        
        boolean res = false;
        if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j]) {
            res |= isSolve1(heights, i - 1, j, visited);
        }
        if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]) {
            res |= isSolve1(heights, i, j - 1, visited);
        }
        if (i + 1 < heights.length && heights[i + 1][j] <= heights[i][j]) {
            res |= isSolve1(heights, i + 1, j, visited);
        }
        if (j + 1 < heights[0].length && heights[i][j + 1] <= heights[i][j]) {
            res |= isSolve1(heights, i, j + 1, visited);
        }
        
        return res;
    }
    
    public boolean isSolve2(int[][] heights, int i, int j, boolean[][] visited) {
        if (i == heights.length - 1 || j == heights[0].length - 1) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        
        boolean res = false;
        if (i + 1 < heights.length && heights[i + 1][j] <= heights[i][j]) {
            res |= isSolve2(heights, i + 1, j, visited);
        }
        if (j + 1 < heights[0].length && heights[i][j + 1] <= heights[i][j]) {
            res |= isSolve2(heights, i, j + 1, visited);
        }
        if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j]) {
            res |= isSolve2(heights, i - 1, j, visited);
        }
        if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]) {
            res |= isSolve2(heights, i, j - 1, visited);
        }
        
        return res;
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] pacificVisited = new boolean[m][n];
                boolean[][] atlanticVisited = new boolean[m][n];
                
                boolean ans1 = isSolve1(heights, i, j, pacificVisited);
                boolean ans2 = isSolve2(heights, i, j, atlanticVisited);
                
                if (ans1 && ans2) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}