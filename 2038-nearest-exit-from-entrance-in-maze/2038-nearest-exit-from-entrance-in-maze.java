
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
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+'; // Mark as visited
        int steps = 0;
        
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];
                
                if (!(x == entrance[0] && y == entrance[1]) &&
                    (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                    return steps;
                }
                
                for (int[] move : moves) {
                    int newX = x + move[0];
                    int newY = y + move[1];
                    
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] != '+') {
                        queue.offer(new int[]{newX, newY});
                        maze[newX][newY] = '+'; // Mark as visited
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
