import java.util.*;

class Solution {
    public boolean isBipartite(Map<Integer, List<Integer>> adj, int node, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 1; // Assign first color

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (color[v] == color[u]) {
                    return false; // Conflict found
                }
                if (color[v] == -1) { // If uncolored
                    color[v] = 1 - color[u]; // Assign opposite color
                    queue.add(v);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : dislikes) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1]; // 0 = unvisited, 1 = group A, -1 = group B
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!isBipartite(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
