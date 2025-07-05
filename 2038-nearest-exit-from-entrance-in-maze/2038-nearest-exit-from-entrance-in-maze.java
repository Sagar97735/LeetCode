
   // --------------------------->DFS APPROACH<---------------------------------
    // public void isSolve(char[][] maze, int i, int j, int step, int[] ans, boolean[][] visit, int[] entrance) {
    //     // Base conditions: Out of bounds or visited cell or wall
    //     if (i >= maze.length || j >= maze[0].length || i < 0 || j < 0 || visit[i][j] || maze[i][j] == '+') {
    //         return;
    //     }

    //     // Mark the cell as visited
    //     visit[i][j] = true;

    //     // If it's an exit and not the entrance itself, update the minimum steps
    //     if ((i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1) && !(i == entrance[0] && j == entrance[1])) {
    //         ans[0] = Math.min(ans[0], step);
    //     } else {
    //         // Explore all four directions
    //         isSolve(maze, i + 1, j, step + 1, ans, visit, entrance);
    //         isSolve(maze, i - 1, j, step + 1, ans, visit, entrance);
    //         isSolve(maze, i, j + 1, step + 1, ans, visit, entrance);
    //         isSolve(maze, i, j - 1, step + 1, ans, visit, entrance);
    //     }

    //     // Unmark the cell for backtracking
    //     visit[i][j] = false;
    // }

class Solution {
    public class pair{
        int x;
        int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int step = 0;
        Queue<pair> q1 = new LinkedList<>();
        q1.add(new pair(entrance[0],entrance[1]));
        while(!q1.isEmpty()){
            int size = q1.size();
            for(int i = 0; i<size; i++){
            pair curr = q1.poll();
            int newx = curr.x;
            int newy = curr.y;
            if ((newx == 0 || newx == m - 1 || newy == 0 || newy == n - 1) 
    && !(newx == entrance[0] && newy == entrance[1])) {
    return step;
}

            if(newx+1<m && maze[newx+1][newy]!='+' && !(newx+1==entrance[0] && newy ==entrance[1])){
                q1.add((new pair(newx+1,newy)));
                maze[newx+1][newy] = '+';
            }
            if(newx-1>=0 && maze[newx-1][newy]!='+' && !(newx-1==entrance[0] && newy ==entrance[1])){
                q1.add((new pair(newx-1,newy)));
                maze[newx-1][newy] = '+';
            }
            if(newy+1<n && maze[newx][newy+1]!='+' && !(newx==entrance[0] && newy+1 ==entrance[1])){
                q1.add((new pair(newx,newy+1)));
                maze[newx][newy+1] = '+';
            }
            if(newy-1>=0 && maze[newx][newy-1]!='+' && !(newx==entrance[0] && newy-1 ==entrance[1])){
                q1.add((new pair(newx,newy-1)));
                maze[newx][newy-1] = '+';
            }
             
            }
           

             step = step+1;
        }
        return -1;
    }
}
