class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int i =0;
        int j = height.length-1;
        int width = j;
        while(i!=j){
           if(height[i]<height[j]){
               maxarea = Math.max(maxarea,width*height[i]);
               i++;
               width--;
           }
           else{
               maxarea = Math.max(maxarea,width*height[j]);
               j--;
               width--;
           }
        }
            return maxarea;
    }
}