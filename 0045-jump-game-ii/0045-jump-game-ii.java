//uning recursion
// class Solution {
    
//     public int jump(int[] nums) {
//         return recJump(nums, 0);
//     }

//      public int recJump(int [] nums, int idx){
//          if(idx == nums.length - 1)
//              return 0;

//          int min = 99999;
//          for(int i = idx+1; (i <= idx + nums[idx] && i < nums.length); i++){
//              min = Math.min(min, recJump(nums, i)+1);
//          }
//          return min;
//      }}

class Solution {
    
    public int jump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return memoJump(nums, 0, dp);
    }

     public int memoJump(int [] nums, int idx, int [] dp){
         if(idx == nums.length - 1)
             return dp[idx] = 0;
        
         if(dp[idx] != -1)
             return dp[idx];

         int min = 99999;
         for(int i = idx+1; (i <= idx + nums[idx] && i < nums.length); i++){
             min = Math.min(min, memoJump(nums, i, dp)+1);
         }
         return dp[idx] = min;
     }
}