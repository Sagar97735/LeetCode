class Solution {
    public int trap(int[] height) {
    int lmax = 0;
    int rmax = 0;
    int trapwater = 0;
    int [] leftmax = new int[height.length];
    int [] rightmax = new int[height.length];
    for(int i =0; i<height.length; i++){
        lmax = Math.max(height[i],lmax);
        leftmax[i] = lmax;
    }
    for(int i =height.length-1; i>=0; i--){
        rmax = Math.max(height[i],rmax);
        rightmax[i] = rmax;
    }
    for(int i =1; i<rightmax.length-1; i++){
        int ans = Math.min(leftmax[i],rightmax[i])-height[i];
        if(ans>0){ 
            trapwater+=ans;
    }
    }
  return trapwater;
    }
}