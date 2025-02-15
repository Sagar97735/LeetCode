class Solution {
    public int maxSubArray(int[] nums) {
    
        int ans = 0;
        int max = Integer.MIN_VALUE;
    for(int i =0; i<nums.length; i++){
        ans+=nums[i];
        if(ans>max){
            max = Math.max(ans,max);
        }
        if(ans<0){
            ans=0;
        }
    }
    return max;
    }
}