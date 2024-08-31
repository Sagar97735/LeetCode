class Solution {
    public int equalPairs(int[][] grid){
        int [][] ans = new int[grid.length][grid.length]; 
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length;j++){
               ans[i][j] = grid[j][i];
            }
        }

        int count = 0;
             for(int i = 0; i<grid.length; i++){
                int [] arr = ans[i];
                for(int j = 0; j<grid[0].length;j++){
                int [] arr1 = grid[j];
                if(Arrays.equals(arr,arr1)){
                count++;
             }
            }
              
        }
        return count;   
    }
}