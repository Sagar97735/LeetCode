class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int j =0;
        int min = nums.length+1;
        int i = 0;
        while(j<nums.length){
             ans+=nums[j];
           while(ans>=target){
            min = Math.min(min,j-i+1);
            ans-=nums[i];
            i++;
           }
          
           j++;
    }
        return (min == nums.length+1) ? 0 : min;
    }
}