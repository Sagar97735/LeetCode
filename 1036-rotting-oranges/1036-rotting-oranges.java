class Solution {
    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<pair> q1 = new LinkedList<>();
        int rotten = 0;
        int total = 0;
        int time = 0;
        int n = grid[0].length;
        int m = grid.length;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q1.add(new pair(i,j));
                }
                if(grid[i][j]==1 || grid[i][j]==2){
                    total++;
                }
            }
        }
         if(total == 0){
    return 0;
   }
while(!q1.isEmpty()){
  
   int size=q1.size();
    rotten += size;
    if(rotten ==total){
        return time;
    }
    time++;
    for(int i=0; i<size;i++ ){
        pair curr = q1.peek();
    if(curr.y+1<n && grid[curr.x][curr.y+1] == 1){
        grid[curr.x][curr.y+1] = 2;
        q1.add(new pair(curr.x , curr.y+1));
    }
   if(curr.y-1>=0 && grid[curr.x][curr.y-1] == 1){
        grid[curr.x][curr.y-1] = 2;
        q1.add(new pair(curr.x , curr.y-1));
    }
    if(curr.x+1<m && grid[curr.x+1][curr.y] == 1){
        grid[curr.x +1][curr.y] = 2;
        q1.add(new pair(curr.x+1 , curr.y));
    }
    if(curr.x-1>=0 && grid[curr.x-1][curr.y] == 1){
        grid[curr.x -1][curr.y] = 2;
        q1.add(new pair(curr.x -1 , curr.y));
    }
   q1.poll();
}
}
return -1;
    }
}
