class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
      int [] arr = new int[(grid.length*grid.length) +1];
      int rep = 0;
      int mis = 0;
      for(int i =0; i<grid.length; i++){
       for(int j =0; j<grid[i].length; j++){
         int a = grid[i][j];
        if(arr[a]!=0){
            rep = a;
        }
        else if(arr[a]==0){
                arr[a]=a;
        }
       }
        
      }
      
      for(int i =1; i<arr.length; i++){
        if(arr[i]==0){
            mis = i;
        }
      } 
      int [] ans = new int[2];
      ans[0]= rep;
      ans[1] = mis;
      return ans; 
    }
}