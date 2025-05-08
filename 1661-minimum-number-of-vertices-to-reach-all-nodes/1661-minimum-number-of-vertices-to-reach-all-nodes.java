class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> arr = new ArrayList<>();
        int [] indegree = new int[n];
        for(int i =0; i<edges.size(); i++){
            int a = edges.get(i).get(1);
            indegree[a]++;
        }
        for(int i =0; i<n; i++){
          if(indegree[i]==0){
            arr.add(i);
          }
        }
        return arr;
    }
}