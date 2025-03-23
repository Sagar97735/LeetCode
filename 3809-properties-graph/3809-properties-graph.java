import java.util.*;

class Solution {
    // DFS function to traverse the connected components
    public void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    // Function to check if two arrays have at least 'k' common distinct elements
    public boolean intersect(int[] a1, int[] a2, int k) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : a1) set1.add(num);
        
        int count = 0;
        for (int num : a2) {
            if (set1.contains(num)) {
                count++;
                set1.remove(num); // Remove to avoid counting duplicates
            }
            if (count >= k) return true;
        }
        return false;
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph based on intersection condition
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(properties[i], properties[j], k)) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // Find connected components using DFS
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++;
            }
        }

        return components;
    }
}
