class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Queue<Integer> q1 = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        boolean [] visited = new boolean [n];
        q1.add(source);
        visited[source] = true;
        for(int i =0; i<n; i++){
           arr.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        while(!q1.isEmpty()){
            int curr = q1.poll();
            visited[curr] = true;
            for(int i =0; i<arr.get(curr).size();i++){
                int neigh = arr.get(curr).get(i);
                if(neigh==destination){
                return true;
            }
                if(!visited[neigh]){
                    q1.add(neigh);
                    visited[neigh] = true; 
                }
            }
        }
        return false;
    }
}