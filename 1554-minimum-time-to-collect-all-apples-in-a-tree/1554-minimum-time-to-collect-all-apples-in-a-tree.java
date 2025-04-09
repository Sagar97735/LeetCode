class Solution {
    public int isSolve(int parent , int child, List<List<Integer>> arr,List<Boolean> hasApple){
   int time = 0;
   for(int i =0; i<arr.get(child).size();i++){
         int ch = arr.get(child).get(i);
         if(ch==parent){
            continue;
         }
         int time_from_child = isSolve(child,ch,arr,hasApple);
         if(time_from_child>0 || hasApple.get(ch)){
            time += time_from_child +2;
         }
   }
   return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i =0; i<n; i++){
            arr.add(new ArrayList<>());
            
        }
        for(int i =0; i<edges.length; i++){
           int u =  edges[i][0];
           int v =  edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        return isSolve(-1,0,arr,hasApple);
    }
}