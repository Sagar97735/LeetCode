class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        int a = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==target){
              return i;
            }
        }
    // int start1 = 0;
    // int end1 = 0;
    // int end = nums.length-1;
    // int start = 0;
    //  if(nums[nums.length-1]!=nums[index]){
    //     start1 = index+1;
    //     end1 = nums.length-1;
    //     start =0;
    //     end = index-1;
    //  }
      
    //    while(start<=end || start1<=end1){
    //      int mid1 = start + (end - start) / 2;
    //      int mid2 = start1 + (end1-start1)/2;
    //     if(nums[mid1]<target){
    //       start = mid1+1;
    //     }
    //      if(nums[mid1]>target){
    //       end = mid1-1;
    //     }
    //      if(nums[mid2]<target){
    //       start1 = mid2+1;
    //     }
    //     else if(nums[mid2]>target){
    //       end1 = mid2-1;
    //     }
    //    if(nums[mid1]==target){
    //     return mid1;
    //    }
    //    if(nums[mid2]==target){
    //     return mid2;
    //    }
    //    } 
       return -1;
    }
}