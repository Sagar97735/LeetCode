class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int and =  nums[0];
        for(int i =0; i<nums.length; i++){
          if(nums[i]!=and){
            return 1;
          }
        }
        return 0;
    }
}