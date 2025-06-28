class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int[2];
        Arrays.fill(ans,-1);
        int start = 0;
        int i = 0;
        int j = 0;
        int end = nums.length-1;
        int mid = (start + end)/2;
        while(start<=end){
            mid = (start + end)/2;
            if(nums[mid]<target){
               start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                i = mid;
                while(i>=0 && nums[i]==target){
                    i--;
                }
                i = i+1;
                ans[0] = i;
                while(i<nums.length && nums[i]==target){
                    i++;
                }
                ans[1] = i-1;
                break;
            }
        }
        return ans;
    }
}