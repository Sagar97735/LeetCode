class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] arr = new int[n][n];
        for(int i =0; i<queries.length; i++){
           int x1 = queries[i][0];
           int y1 = queries[i][1];
           int x2 = queries[i][2];
           int y2 = queries[i][3];
           for(int x =x1; x<=x2; x++){
            for(int y = y1; y<=y2; y++){
               arr[x][y]+=1;
            }
           }
        }
        return arr;
    }
}