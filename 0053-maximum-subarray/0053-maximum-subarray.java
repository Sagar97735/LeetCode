class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int currsum =0;
        for(int i =0; i<nums.length; i++){
            currsum+=nums[i];
            max = Math.max(max,nums[i]);
            sum = Math.max(currsum,sum);
            if(currsum<0){
                currsum = 0;
            }
        }
        if(max<0){
            return max;
        }
        return sum;
    }
}