class Solution {
    // Pair class for (node, distance)
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Pair(v, w));
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Min Heap based on distance
PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist );

        pq.offer(new Pair(k, 0));

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {

            Pair current = pq.poll();
            int node = current.node;
            int currentDist = current.dist;

            if (currentDist > dist[node]) continue;

            for (Pair neighbor : graph.get(node)) {

                int nextNode = neighbor.node;
                int weight = neighbor.dist;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        // Step 5: Find maximum time
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}