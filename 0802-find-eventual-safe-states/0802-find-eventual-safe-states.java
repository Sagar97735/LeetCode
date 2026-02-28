class Solution {

    public boolean solve(int[][] graph, int node, int[] state) {

        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1; // visiting

        for (int neigh : graph[node]) {
            if (!solve(graph, neigh, state)) {
                return false;
            }
        }

        state[node] = 2; // safe
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] state = new int[n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (solve(graph, i, state)) {
                ans.add(i);
            }
        }

        return ans;
    }
}