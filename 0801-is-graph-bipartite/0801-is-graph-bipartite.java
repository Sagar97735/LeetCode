class Solution {
    public boolean dfs(int[][] graph,int currcolor,int [] color,int curr){
     color[curr] = currcolor;
     for(int i =0; i< graph[curr].length; i++){
        int neigh = graph[curr][i];
        if(color[neigh]==color[curr]){
            return false;
        }
        else if(color[neigh]==-2){
            currcolor = 1-color[curr];
            if(dfs(graph,currcolor,color,neigh)== false){
                return false;
            }
        }
     }
     return true;
    }
    //boolean ans = false; if we make ans then value updated
    //means if after detect same color ans is false but when it
    //linear then it becomes true for same graph.
    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color,-2);
        for(int i = 0; i< graph.length; i++){
        if(color[i]==-2){
            if (!dfs(graph,0,color, i)) {
                    return false;
                }
        }
      
    }
    return true;
}}