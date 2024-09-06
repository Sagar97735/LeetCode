class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        
        ans[0] =-1;
        ans[1] = -1;
        int start = 0;
        int end = nums.length-1;
        int i = -1;
        int j = -1;
        while(start<=end){
             int mid = start + (end-start)/2 ;
             if(mid>=0 && nums[mid]>target){
                end = mid-1;
             }
             else if(mid>=0 && nums[mid]<target){
                start = mid+1;
             }
             else if(mid>=0 && nums[mid]==target){
                i = mid;
                j= mid;
                start = -7899651;
                end =  -11;
             }
             else if(i-1>=0 && nums[i-1]==target){
                    i= i-1;
                }
             else{
                
                  if(j+1<nums.length && nums[j+1]==target){
                    j= j+1;
                }
                else if(i-1<0 || nums[i-1]!=target && j+1>=ans.length || nums[j+1]!=target){
                    ans[0]= i;
                    ans[1] = j;
                   break;
                }
             }  
        }
        // if(nums.length>0 && nums[0]==target){
        //     ans[0] = 0;
        // }
        System.out.print(ans[0]);
        return ans;
    }
}