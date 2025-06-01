class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> list = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }

                Collections.sort(list);
                int min = Integer.MAX_VALUE;
     for (int p = 1; p < list.size(); p++) {
                    if (!list.get(p).equals(list.get(p - 1))) {
                        int diff = Math.abs(list.get(p) - list.get(p - 1));
                        min = Math.min(min, diff);
                    }
                }

                result[i][j] = (min == Integer.MAX_VALUE) ? 0 : min;
            }
        }

        return result;
    }
}
