class Solution {

    public boolean dfs(int[][] graph, int node, boolean[] vis, boolean[] safe) {

        // Agar already safe mark ho chuka hai
        if (safe[node]) return true;

        // Agar currently recursion stack me hai → cycle
        if (vis[node]) return false;

        // Mark as visiting (recursion stack)
        vis[node] = true;

        for (int neigh : graph[node]) {
            if (!dfs(graph, neigh, vis, safe)) {
                return false;
            }
        }

        // Sab neighbours safe nikle
        vis[node] = false;      // remove from recursion stack
        safe[node] = true;      // mark as safe
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] safe = new boolean[n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, vis, safe)) {
                ans.add(i);
            }
        }

        return ans;
    }
}