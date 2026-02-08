class Solution {
    public int dominantIndices(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for(int i =0; i<nums.length; i++){
            sum+=nums[i];
        }
        for(int i =0; i<nums.length-1; i++){
            sum-=nums[i];
            double avg = sum/(nums.length-(i+1));
            if(nums[i]>avg){
             cnt+=1;
            }
        }
        return cnt;
    }
}