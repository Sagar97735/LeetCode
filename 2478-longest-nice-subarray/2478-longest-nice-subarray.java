class Solution {
    public int longestNiceSubarray(int[] nums) {
        int bitmask = 0;
        int start = 0; 
        int end = 0;
        int cnt = 0;
        int max = 0;
        while(end<nums.length){
            if((bitmask&nums[end])!=0){
                bitmask^=nums[start];
                start++;
                cnt--;
            }
            else{
                bitmask|=nums[end];
                end++;
                cnt++;
                if(cnt>max){
                    max = cnt;
                }
            }
        }
            return max;
    }
}