class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int max1 =0;
        int j = 0;
        int i = 0;
        int maxzero = 0;
        int zero = 0;
        while(j<nums.length && i<nums.length){
            if(nums[j]==0){
                zero++;
            }
            maxzero = Math.max(zero,maxzero);
            if(zero ==0 || zero==1){
                max+=nums[j];
                j++;
                max1 = Math.max(max,max1);
                }
            if(zero>1){
                zero = 0;
                max = 0;
                i++;
                j = i;
            }
        }
       if(maxzero==0){
        return max1-1;
       }
        return max1;
    }
}