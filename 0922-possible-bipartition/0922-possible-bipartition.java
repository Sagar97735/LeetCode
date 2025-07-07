public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        for (int i = 1; i <= n; i++) {
            for (int dislike : graph[i]) {
                // If i and dislike are in the same set, not possible
                if (find(parent, i) == find(parent, dislike)) {
                    return false;
                }
                // Union first disliked person of i with the current dislike
                union(parent, graph[i].get(0), dislike);
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}
