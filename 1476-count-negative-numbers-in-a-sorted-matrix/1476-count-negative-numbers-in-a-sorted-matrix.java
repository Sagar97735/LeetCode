class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
            if(grid[i][j]<0){
                cnt++;
            }
            if(grid[i][j]>0){
                break;
            }
            }
        }
        return cnt;
    }
}