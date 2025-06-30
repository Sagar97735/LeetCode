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
       return mid;
    }

    public int search(int[] nums, int target) {
        int ans = 0; 
        int start = findMin(nums);
        int end1 = nums.length-1;
        int end = 0;
        if(start == 0){
            end = nums.length-1;
        }
        else if(nums[start]==target){
            return start;
        }
        else if(nums[0] <= target){
            end = start-1;
            start = 0;
        }
        else if(nums[0] > target){
            end = end1;
        }
        int mid = 0;
         while(start<=end){
            mid = (start + end)/2;
            if(nums[mid]<target){
               start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                return mid;
            }
            
    }
    return -1;
    }
}