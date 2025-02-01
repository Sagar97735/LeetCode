//--------------->solve by using DFS<--------------------
// class Solution {
//     public void solve(ArrayList<ArrayList<Integer>> arr,boolean [] vis,int u){
//        vis[u] = true;
//         for(int i =0; i< arr.get(u).size();i++){
//             int v = arr.get(u).get(i);
//             if(!vis[v]){
//                 solve(arr,vis,v);
//             }
//         }
//         return;
//     }
//     public int findCircleNum(int[][] isConnected) {
//     ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//     for(int i =0; i< isConnected.length; i++){
//         arr.add(new ArrayList<>());
//     }
//     for(int i =0; i<isConnected.length; i++){
//         for(int j =0; j<isConnected[0].length; j++){
//             if(i!=j &&  isConnected[i][j] ==1){
//                 arr.get(i).add(j);
//             }
//         }
//     }   
//    int count = 0;
//    boolean [] vis = new boolean[isConnected.length];
//    for(int i =0; i<arr.size(); i++){
//     if(!vis[i]){
//         count++;
//     solve(arr,vis,i);
//    }}
//    return count;
//     }
// }
//---------------->solve by using BFS<-------------------
class Solution {
    public void bfs(ArrayList<ArrayList<Integer>> arr,boolean[] vis, int u){
          Queue<Integer> q1 = new LinkedList<>();
          q1.add(u);
          vis[u] = true;
          while(!q1.isEmpty()){
            int a = q1.poll();
            for(int i =0; i<arr.get(a).size(); i++){
            int neigh = arr.get(a).get(i);
            if(!vis[neigh]){ 
            vis[neigh] = true;
            q1.add(neigh);
            }
          }}
          return;
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i<isConnected.length; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i< isConnected.length; i++){
            for(int j =0; j<isConnected[i].length;j++){
                if(i!=j && isConnected[i][j]==1){
                   arr.get(i).add(j);
                }
            }
        }
        int count =0;
        boolean [] vis = new boolean[isConnected.length];
      for(int i =0; i<isConnected.length; i++){
        if(!vis[i]){
            count++;
            bfs(arr,vis,i);
        }
      }
return count;
    }
}