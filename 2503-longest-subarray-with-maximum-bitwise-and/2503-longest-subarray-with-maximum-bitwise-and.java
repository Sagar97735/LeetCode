class Solution {
    public int longestSubarray(int[] nums) {
       int max = -1;
       int ans = -1;
       int len = 0;
       for(int i =0; i<nums.length; i++){
        max = Math.max(nums[i], max);
       }
       for(int i =0; i<nums.length; i++){
        if(nums[i]==max){
            len++;
        }
        ans = Math.max(ans,len);
        if(nums[i]!=max){
            len = 0;
        }
       }
       return ans;
    }
}