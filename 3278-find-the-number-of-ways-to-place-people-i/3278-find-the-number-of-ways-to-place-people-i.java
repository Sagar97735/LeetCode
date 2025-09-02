class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int xi = points[i][0], yi = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xj = points[j][0], yj = points[j][1];

                // allow equality on x or y (line cases included)
                if (xi <= xj && yi >= yj) {
                    boolean ok = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int xk = points[k][0], yk = points[k][1];

                        // any point inside or on border invalidates the pair
                        if (xi <= xk && xk <= xj && yj <= yk && yk <= yi) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) ans++;
                }
            }
        }
        return ans;
    }
}
