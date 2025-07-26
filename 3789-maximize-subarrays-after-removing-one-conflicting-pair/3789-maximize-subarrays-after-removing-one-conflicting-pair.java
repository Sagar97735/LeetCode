class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int m = conflictingPairs.length;
        List<int[]>[] byL = new List[n + 2];
        for (int i = 1; i <= n; i++) byL[i] = new ArrayList<>();
        for (int id = 0; id < m; id++) {
            int a = conflictingPairs[id][0], b = conflictingPairs[id][1];
            int L = Math.min(a, b), R = Math.max(a, b);
            byL[L].add(new int[]{R, id});
        }

        // dp[i] = [firstR, firstId, secondR, secondId]
        int[][] dp = new int[n + 2][4];
        dp[n + 1] = new int[]{n + 1, -1, n + 1, -1};

        for (int i = n; i >= 1; i--) {
            // candidates: dp[i+1] and all conflicts starting at i
            List<int[]> cands = new ArrayList<>();
            cands.add(new int[]{dp[i + 1][0], dp[i + 1][1]});
            cands.add(new int[]{dp[i + 1][2], dp[i + 1][3]});
            for (int[] pr : byL[i]) cands.add(pr);
            // pick two smallest by R
            cands.sort((x, y) -> x[0] - y[0]);
            int fR = cands.get(0)[0], fId = cands.get(0)[1];
            int sR = cands.size() > 1 ? cands.get(1)[0] : n + 1;
            int sId = cands.size() > 1 ? cands.get(1)[1] : -1;
            dp[i] = new int[]{fR, fId, sR, sId};
        }

        long base = 0;
        for (int i = 1; i <= n; i++) base += (dp[i][0] - i);

        long[] gain = new long[m];
        for (int i = 1; i <= n; i++) {
            int fR = dp[i][0], fId = dp[i][1];
            int sR = dp[i][2];
            if (fId >= 0) gain[fId] += (long)(sR - fR);
        }

        long ans = base;
        for (long g : gain) ans = Math.max(ans, base + g);
        return ans;
    }
}
