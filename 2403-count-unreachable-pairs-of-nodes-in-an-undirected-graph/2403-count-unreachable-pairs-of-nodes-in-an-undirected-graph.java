class Solution {
    public int bfs(boolean[] visit, List<List<Integer>> arr , int node){
       Queue<Integer> q1 = new LinkedList<>();
       q1.add(node);
       int cnt = 0;
       visit[node] = true;
       while(!q1.isEmpty()){
        int u = q1.poll();
        cnt++;
        for(int i =0; i<arr.get(u).size();i++){
            int v = arr.get(u).get(i);
            if(!visit[v]){
                q1.add(v);
                visit[v] = true;
            }
        }
       }
       return cnt;
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        for(int i =0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
         boolean [] visit = new boolean[n];
          for(int i =0; i<n; i++){
            if(!visit[i]){
                arr1.add(bfs(visit,arr,i));
            }
          }
          long ans = 0;
          long remaining = n;
        for (int size : arr1) {
            remaining -= size;
            ans += (long) size * remaining;
        }
          return ans;
    }
}