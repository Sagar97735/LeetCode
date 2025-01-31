class Solution {
    public void solve(ArrayList<ArrayList<Integer>> arr,boolean [] vis,int u){
       vis[u] = true;
        for(int i =0; i< arr.get(u).size();i++){
            int v = arr.get(u).get(i);
            if(!vis[v]){
                solve(arr,vis,v);
            }
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for(int i =0; i< isConnected.length; i++){
        arr.add(new ArrayList<>());
    }
    for(int i =0; i<isConnected.length; i++){
        for(int j =0; j<isConnected[0].length; j++){
            if(i!=j &&  isConnected[i][j] ==1){
                arr.get(i).add(j);
            }
        }
    }   
   int count = 0;
   boolean [] vis = new boolean[isConnected.length];
   for(int i =0; i<arr.size(); i++){
    if(!vis[i]){
        count++;
    solve(arr,vis,i);
   }}
   return count;
    }
}