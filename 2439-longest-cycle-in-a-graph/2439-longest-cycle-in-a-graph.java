class Solution {
    int ans = 0;

    public void isSolve(int parent, int curr, int[] edges, boolean[] vis, boolean[] inrec, int[] count) {
        if (curr == -1) return;

        if (vis[curr]) {
            if (inrec[curr]) {
                ans = Math.max(ans, count[parent] - count[curr] + 1);
            }
            return;
        }

        vis[curr] = true;
        inrec[curr] = true;

        if (parent >= 0) {
            count[curr] = count[parent] + 1;
        } else {
            count[curr] = 1;
        }

        isSolve(curr, edges[curr], edges, vis, inrec, count);

        inrec[curr] = false;
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        boolean[] inrec = new boolean[n];
        int[] count = new int[n];  // Move count[] outside the loop
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                // You can skip Arrays.fill because count[] will be updated in the recursive call
                isSolve(-1, i, edges, vis, inrec, count);
            }
        }

        return ans == 0 ? -1 : ans;
    }
}
