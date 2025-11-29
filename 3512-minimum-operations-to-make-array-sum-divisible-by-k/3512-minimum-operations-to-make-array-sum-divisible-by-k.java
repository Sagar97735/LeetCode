class Solution {
    public int minOperations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i =0; i<nums.length; i++){
          sum+=nums[i];
          
        }
          if(sum%k==0){
            return 0;
          }
          return sum%k;
    }
}