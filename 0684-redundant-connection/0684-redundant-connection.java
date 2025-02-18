class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int curr , int v, boolean [] visited){
   if(curr==v){
    return true;
   }
   visited[curr] = true;
   for(int i = 0; i<adj.get(curr).size();i++){
    int neigh = adj.get(curr).get(i);
     if (!visited[neigh]) {
            if (dfs(adj, neigh, v, visited)) {
                return true;  // If a path is found, return true
            }
        }
   }
   return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for(int i =0; i<=edges.length; i++){
        adj.add(new ArrayList<>());
     }
     for(int [] edge : edges){
          int u = edge[0];
          int v = edge[1];
           if (!adj.get(u).isEmpty() && !adj.get(v).isEmpty()) {
                boolean[] visited = new boolean[n + 1];
                if (dfs(adj, u, v, visited)) {
                    return edge; // Found the redundant edge
                }
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
     } 
     return new int[0];  
    }
}