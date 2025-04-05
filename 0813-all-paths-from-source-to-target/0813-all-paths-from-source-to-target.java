class Solution {
public void isSolve(int[][] graph ,int src, List<List<Integer>> arr, int n,List<Integer> arr1){
    arr1.add(src);
    if(src==n){
            arr.add(new ArrayList<>(arr1));  // Important: add a copy of arr1
     }
    for(int i =0; i<graph[src].length; i++){
        int neigh = graph[src][i];
         isSolve(graph,neigh,arr,n,arr1);
    }
       arr1.remove(arr1.size() - 1);
    return;
}
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        int n = graph.length;
        isSolve(graph,0,arr,n-1,arr1);
        return arr;
    }
}