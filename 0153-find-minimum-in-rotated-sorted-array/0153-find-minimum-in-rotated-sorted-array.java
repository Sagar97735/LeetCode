class Solution {
    public int findMin(int[] nums) {
        
       int start = 0;
       int end = nums.length-1;
       int mid = 0;
       while(start<end){
          mid = (start + end)/2;
          if(nums[mid]<nums[end]){
            end = mid;
          }
          else if(nums[mid]>nums[end]){
            start = mid+1;
            mid = start;
          }
       }
       return nums[mid];
    }
}