class Solution {
    public int maxProduct(int[] nums) {
      int maxm = nums[0];
      int minm = nums[0];
      int result = nums[0];
      for(int i =1; i<nums.length;i++){
        int tempmaxm= maxm;
        maxm = Math.max(nums[i], Math.max(tempmaxm * nums[i], minm * nums[i]));
        minm = Math.min(nums[i], Math.min(tempmaxm * nums[i], minm * nums[i]));
        result = Math.max(result,maxm);
      }
      return result;
    }
}