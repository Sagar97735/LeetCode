class Solution {
    public int longestSubarray(int[] nums) {
        int max = -1;
        int ans = 0;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(nums[i],max); 
        }
        for(int j =0 ; j<nums.length; j++){
            if(nums[j]==max){
               count++;
            }
             ans = Math.max(count,ans);
            if(nums[j]!=max){
               count = 0;
            }
        }
        return ans;
    }
}