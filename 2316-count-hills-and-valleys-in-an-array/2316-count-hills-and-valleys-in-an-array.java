class Solution {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for(int i =1; i<nums.length-1; i++){
         if(nums[i]==nums[i-1]){
            continue;
         }
         int left = i-1;
         while(left>=0 && nums[left]==nums[i]) left--;
         int right = i+1;
         while(right<n && nums[right]==nums[i]) right++;
         if(left>=0 && right<n){
            if(nums[left]<nums[i] && nums[right]<nums[i]){
                cnt++;
            }
            else if(nums[left]>nums[i] && nums[right]>nums[i]){
                cnt++;
            }
         }
        }
        return cnt;
    }
}