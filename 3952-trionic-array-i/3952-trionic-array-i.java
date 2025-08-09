class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 0;
        int q = 0;
        for(int i =0; i< nums.length-1; i++){
            if(nums[i]<nums[i+1]){
                p++;
            }
            else if(nums[i]>nums[i+1]){
                break;
            }
            else{
                return false;
            }
        }
        q = p;
        for(int i =p; i< nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                q++;
            }
            else if(nums[i]<nums[i+1]){
                break;
            }
            else{
                return false;
            }
        }
        if(p==q || p==0 || q==nums.length-1 || p==nums.length-1){
            return false;
        }
        for(int i =q; i< nums.length-1; i++){
            if(nums[i]>nums[i+1] || nums[i]==nums[i+1]){
                return false;
            }
        }
return true;
    }
}