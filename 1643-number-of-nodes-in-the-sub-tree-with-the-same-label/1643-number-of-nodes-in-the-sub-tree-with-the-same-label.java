class Solution {
    public int[] dfs(int child, int parent, List<List<Integer>> adj, String labels, int[] result) {
        int[] myCount = new int[26];  // To store frequency of characters
        char myLabel = labels.charAt(child);
        myCount[myLabel - 'a'] = 1;  // Count current node's label
        
        for(int v : adj.get(child)) {
            if(v == parent) continue;  // Skip parent node
            
            int[] childCount = dfs(v, child, adj, labels, result);
            
            for(int i = 0; i < 26; i++) {
                myCount[i] += childCount[i];  // Add child count to current node's count
            }
        }
        
        result[child] = myCount[myLabel - 'a'];  // Store the result for current node
        
        return myCount;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Building the graph
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] result = new int[n];
        
        dfs(0, -1, adj, labels, result);
        
        return result;
    }
}