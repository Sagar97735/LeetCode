class Solution {
    int n;

    void bfs(int[] edges, int startNode, int[] distNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(startNode);
        visited[startNode] = true;
        distNode[startNode] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u];

            if (v != -1 && !visited[v]) {
                visited[v] = true;
                distNode[v] = distNode[u] + 1;
                queue.offer(v);
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistTillNow) {
                    minDistTillNow = maxDist;
                    minDistNode = i;
                }
            }
        }

        return minDistNode;
    }
}
