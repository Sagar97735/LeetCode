class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start<=end){
          mid = (start + end)/2;
          if(mid-1>=0 && nums[mid]==nums[mid-1]){
           if((mid-start+1)%2==0){
                 start = mid+1;
            }
            else{
                end = mid;
            }
          }
          else if(mid+1<nums.length && nums[mid]==nums[mid+1]){
            if((mid-start+1)%2==1){
                 start = mid+2;
            }
            else{
                end = mid;
            }
          }
          else{
            return nums[mid];
          }
        }
        return nums[mid];
    }
}