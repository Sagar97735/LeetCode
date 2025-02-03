class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int countinc = 1;
        int incans = 1;
        int countdec =1;
        int decans = 1;
        for(int i =0; i< nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                countinc++;
                incans = Math.max(incans,countinc);
            }
            else{
                countinc=1;
            }
        }
        for(int i =0; i< nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                countdec++;
                 decans = Math.max(decans,countdec);
            }
            else{
                countdec=1;
            }
        }
        return Math.max(decans,incans);
    }
}