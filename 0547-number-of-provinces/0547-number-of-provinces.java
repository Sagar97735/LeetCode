class Solution {
    public static void bfs(int isConnected[][], boolean vis[],int a){
      Queue<Integer> q1 = new LinkedList<>();
      q1.add(a);
      vis[a]=true;
      int v = isConnected.length;
      while(!q1.isEmpty()){
        int curr = q1.poll();
        for(int i =0;i<v;i++){
            if(isConnected[curr][i]==1 && vis[i]==false){
                q1.add(i);
                vis[i]=true;
            }
        }
      }
       }
    
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean vis [] = new boolean[n];
        for(int i = 0; i<n; i++){
          if(vis[i]==false){
            count++;
            bfs(isConnected,vis,i);
          }
        }
        return count;
    }
}