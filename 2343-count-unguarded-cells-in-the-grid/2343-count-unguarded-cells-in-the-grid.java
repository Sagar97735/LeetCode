class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
     int [][] visited = new int[m][n];
     int cnt = 0;
     for(int i =0; i<guards.length; i++){
     int a = guards[i][0];
     int b = guards[i][1];
     visited[a][b] = 2;
    }
    for(int i =0; i<walls.length; i++){
     int a = walls[i][0];
     int b = walls[i][1];
     visited[a][b] = 2;
    }
    for(int i =0; i< guards.length; i++){
        int row = guards[i][0];
        int col = guards[i][1];
        int r = row;
        int c = col;
        while(row+1<m && visited[row+1][col] !=2){
              row = row+1;
              visited[row][c] = 1;
        }
        while(col+1<n && visited[r][col+1] !=2){
              col = col+1;
              visited[r][col] = 1;
        }
        row = r;
        col = c;
        while(row-1>=0 && visited[row-1][col] !=2){
              row = row-1;
              visited[row][c] = 1;
        }
        while(col-1>=0 && visited[r][col-1] !=2){
              col = col-1;
              visited[r][col] = 1;
        }
    }
    for(int i =0 ; i<visited.length; i++){
        for(int j =0; j< visited[0].length; j++){
            if(visited[i][j]!=1 && visited[i][j]!=2){
                cnt++;
            }
        }
    }
    return cnt;
    }
}