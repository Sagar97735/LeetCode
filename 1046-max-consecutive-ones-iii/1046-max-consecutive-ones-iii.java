class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        for(int x =0; x<nums.length; x++){
            if(max>nums.length-x){
                return max;
            }
        int ans = 0;
        int j =0;
        for(int i =x; i<nums.length; i++){
              if(nums[i]==0){
                j++;
            }
            if(nums[i]==1 &&j<=k || nums[i]==0 && j<=k){
                ans+= 1;
            }
             if(j>k||i==nums.length-1){
                   max = Math.max(ans,max);
                   break;

            }
            }
        }
        return max;
    }
}