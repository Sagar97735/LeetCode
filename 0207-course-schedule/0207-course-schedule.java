class Solution {
    public static boolean dfs(int i, boolean[] stack,boolean [] vis , ArrayList<ArrayList<Integer>> arr){
        vis[i]   = true;
        stack[i] = true;
        for(int neighbour : arr.get(i)){
            if(!vis[neighbour]){
               if(dfs(neighbour,stack,vis,arr)){
                return true;
               }
            }
            else if(stack[neighbour]){
                return true;
            }
        }
        stack[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
       for(int j=0; j<numCourses; j++){
        arr.add(new ArrayList<>());
       }
        for(int i=0; i<prerequisites.length; i++){
          arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
      boolean [] stack   = new boolean[numCourses];
      boolean [] vis = new boolean[numCourses];
      for(int i = 0; i<arr.size(); i++){
             if(!vis[i]){
              if(dfs(i,stack,vis,arr)){
                return false;
              }          
             }          
      }
      return true;
    }}