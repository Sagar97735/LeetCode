class Solution {
    public boolean divideArray(int[] nums) {
        int i =0;
        int j =1;
        Arrays.sort(nums);
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                return false;
            }
            i+=2;
            j+=2;
        }
        return true;
    }
}