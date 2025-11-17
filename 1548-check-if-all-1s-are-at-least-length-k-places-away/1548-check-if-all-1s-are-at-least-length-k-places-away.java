class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int j = -1;
        int i = -1;
        for(int l =0; l<nums.length; l++){
            if(nums[l]==1){
                i = j;
                j = l;
                if(i!=-1 && j!=-1 && (j-i-1)<k){
                    return false;
                }
            }
        }
        return true;
    }
}