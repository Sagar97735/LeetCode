class Solution {
    private int m, n;
    private int[][] g, ps; // prefix sum of ones
    private java.util.HashMap<Long, Integer> memo = new java.util.HashMap<>();
    private static final int INF = 1_000_000_000;

    public int minimumSum(int[][] grid) {
        this.g = grid;
        m = grid.length; 
        n = grid[0].length;
        buildPrefix();
        return dfs(0, 0, m - 1, n - 1, 3); // exactly 3 rectangles
    }

    // DP: minimum sum area to cover all 1's in [r1..r2] x [c1..c2] using exactly k rectangles
    private int dfs(int r1, int c1, int r2, int c2, int k) {
        if (r1 > r2 || c1 > c2) return INF;
        int ones = countOnes(r1, c1, r2, c2);
        if (ones == 0) return INF;          // no 1's -> invalid (non-zero area rectangles required)
        if (k == 1) return minAreaOneRect(r1, c1, r2, c2); // one rectangle: bounding box of 1's
        if (ones < k) return INF;           // not enough 1's to give each rectangle at least one
        if (ones == k) return k;            // each 1 as a 1x1 rectangle

        long key = key(r1, c1, r2, c2, k);
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        int best = INF;

        // Try horizontal splits
        for (int split = r1; split < r2; split++) {
            int topOnes = countOnes(r1, c1, split, c2);
            int bottomOnes = ones - topOnes;
            if (topOnes == 0 || bottomOnes == 0) continue; // both parts must contain 1's
            // distribute rectangles: k1 to top, k-k1 to bottom
            for (int k1 = 1; k1 < k; k1++) {
                if (topOnes < k1 || bottomOnes < (k - k1)) continue; // prune impossible distributions
                int up = dfs(r1, c1, split, c2, k1);
                if (up >= INF) continue;
                int down = dfs(split + 1, c1, r2, c2, k - k1);
                if (down >= INF) continue;
                best = Math.min(best, up + down);
            }
        }

        // Try vertical splits
        for (int split = c1; split < c2; split++) {
            int leftOnes = countOnes(r1, c1, r2, split);
            int rightOnes = ones - leftOnes;
            if (leftOnes == 0 || rightOnes == 0) continue;
            for (int k1 = 1; k1 < k; k1++) {
                if (leftOnes < k1 || rightOnes < (k - k1)) continue;
                int left = dfs(r1, c1, r2, split, k1);
                if (left >= INF) continue;
                int right = dfs(r1, split + 1, r2, c2, k - k1);
                if (right >= INF) continue;
                best = Math.min(best, left + right);
            }
        }

        memo.put(key, best);
        return best;
    }

    // area of the minimal rectangle covering all 1's inside the subgrid
    private int minAreaOneRect(int r1, int c1, int r2, int c2) {
        int minR = m, maxR = -1, minC = n, maxC = -1;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (g[i][j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        if (maxR == -1) return INF; // no ones (shouldn't happen because caller checks)
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    // prefix sum helpers
    private void buildPrefix() {
        ps = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += g[i][j];
                ps[i + 1][j + 1] = ps[i][j + 1] + rowSum;
            }
        }
    }

    private int countOnes(int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2) return 0;
        return ps[r2 + 1][c2 + 1] - ps[r1][c2 + 1] - ps[r2 + 1][c1] + ps[r1][c1];
    }

    private long key(int r1, int c1, int r2, int c2, int k) {
        // pack into a long (each index < 31). store k as 0..2
        long t = (((((long) r1) * 31 + c1) * 31 + r2) * 31 + c2);
        return (t << 2) | (k - 1);
    }
}
