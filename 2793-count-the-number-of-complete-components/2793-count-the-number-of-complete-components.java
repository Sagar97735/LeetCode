class Solution {
    Set<Integer> vis = new HashSet<>();
    Map<Integer, Set<Integer>> nodes;
    public int countCompleteComponents(int n, int[][] edges) {
        //build graph to store all neighbors of each node, by loop the edge.
        nodes = buidGraph(edges);
        //Do BFS and check for each islands, res++ if complete.
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (vis.contains(i)) continue;
            if (bfs(i)) result++;
        }
        return result;
    }

    private Map<Integer, Set<Integer>> buidGraph(int[][] edges) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int[] e : edges) {
            nodes.putIfAbsent(e[0], new HashSet<>());
            nodes.putIfAbsent(e[1], new HashSet<>());
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }
        return nodes;
    }

    private boolean bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis.add(i);
        int cntOfNeighs = nodes.getOrDefault(i, new HashSet<>()).size(), numOfNodes = 0;
        boolean result = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            numOfNodes++;
            if (nodes.getOrDefault(curr, new HashSet<>()).size() != cntOfNeighs) result = false;
            for (int neig : nodes.getOrDefault(curr, new HashSet<>())) {
                if (vis.contains(neig)) continue;
                vis.add(neig);
                q.offer(neig);
            }
        }
        return result && cntOfNeighs == numOfNodes - 1;
    }
} 