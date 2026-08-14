class Solution {
    public int solve(int [] nums,int i,int target,int max){
          if(i>=nums.length && max!=target){
            return 0;
          }
          if(max==target && i ==nums.length){
            return 1;
          }
          int c1 = 0;
          int c2 = 0;
         c1 += solve(nums,i+1,target,max+nums[i]);
         c2 += solve(nums,i+1,target,max-nums[i]);
          return c1+c2;
}
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,0,target,0);
    }
}