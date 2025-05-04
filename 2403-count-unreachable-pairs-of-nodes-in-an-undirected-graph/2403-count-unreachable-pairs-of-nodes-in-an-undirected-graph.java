class Solution {
    public int find(int i, int [] parent){
        if(i==parent[i]){
            return i;
        }
        return parent[i] = find(parent[i],parent);
    }
    public void union(int a, int b, int [] parent){
        int a_parent = find(a,parent);
        int b_parent = find(b,parent);
        if(a_parent!=b_parent){
            parent[a_parent] = b_parent;
        }
    }
    public long countPairs(int n, int[][] edges) {
        int [] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        HashMap<Integer,Integer> h1 = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for(int i =0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            union(a,b,parent);
        }
        for(int i =0; i<n; i++){
          int node_parent = find(i,parent);
          h1.put(node_parent,h1.getOrDefault(node_parent,0)+1);
        }
        long max = n;
       for (Map.Entry<Integer, Integer> entry : h1.entrySet()) {
            int a = entry.getValue();
            arr.add(a);
   }
     long ans = 0;
        for(int i =0; i<arr.size();i++){
            max-=arr.get(i);
            long a = arr.get(i)*max;
            ans+=a;
        }
        return ans;
    }
}