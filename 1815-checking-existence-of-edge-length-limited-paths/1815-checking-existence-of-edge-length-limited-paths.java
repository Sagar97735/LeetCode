//----------------->This is my method by using DFS<-----------------------
// class Solution {
//     public boolean dfs(int u, int v, int limit, List<HashMap<Integer, Integer>> arr, boolean[] visited) {
//     if (u == v) return true;
//     visited[u] = true;

//     for (Map.Entry<Integer, Integer> entry : arr.get(u).entrySet()) {
//         int dest = entry.getKey();
//         int dist = entry.getValue();

//         if (!visited[dest] && dist < limit) {
//             if (dfs(dest, v, limit, arr, visited)) return true;
//         }
//     }

//     return false;
// }
//     public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
//     List<HashMap<Integer,Integer>> arr = new ArrayList<>();
//     for(int i = 0; i < n; i++) {
//         arr.add(new HashMap<>());
//     }

//     for(int[] edge : edgeList) {
//         int u = edge[0], v = edge[1], dist = edge[2];
//         // Store the smallest weight between same nodes
//         arr.get(u).put(v, Math.min(arr.get(u).getOrDefault(v, Integer.MAX_VALUE), dist));
//         arr.get(v).put(u, Math.min(arr.get(v).getOrDefault(u, Integer.MAX_VALUE), dist));
//     }

//     boolean[] ans = new boolean[queries.length];
//     for(int i = 0; i < queries.length; i++) {
//         int u = queries[i][0];
//         int v = queries[i][1];
//         int limit = queries[i][2];
//         boolean[] visited = new boolean[n];

//         ans[i] = dfs(u, v, limit, arr, visited);  // only path with edges < limit
//     }

//     return ans;
// }
// }
import java.util.*;

class Solution {
    // Union-Find (DSU) helper class
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) parent[px] = py;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // Sort edgeList by weight
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        // Add index to queries so we can return answers in order
        int qLen = queries.length;
        int[][] indexedQueries = new int[qLen][4];
        for (int i = 0; i < qLen; i++) {
            indexedQueries[i][0] = queries[i][0];
            indexedQueries[i][1] = queries[i][1];
            indexedQueries[i][2] = queries[i][2];
            indexedQueries[i][3] = i; // original index
        }

        // Sort queries by limit
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[2], b[2]));

        boolean[] answer = new boolean[qLen];
        DSU dsu = new DSU(n);
        int edgeIndex = 0;

        // Process each query in increasing order of limit
        for (int[] q : indexedQueries) {
            int u = q[0], v = q[1], limit = q[2], idx = q[3];

            // Add all edges with weight < limit to DSU
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int a = edgeList[edgeIndex][0];
                int b = edgeList[edgeIndex][1];
                dsu.union(a, b);
                edgeIndex++;
            }

            // Check if u and v are connected
            answer[idx] = dsu.find(u) == dsu.find(v);
        }

        return answer;
    }
}
