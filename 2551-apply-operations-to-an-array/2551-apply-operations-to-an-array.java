class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i =0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i] = 2*nums[i];
                nums[i+1]=0;
            }
        }
        int i = 0;
    for(int n: nums){                     // collect all noon zero values at front
        if(n != 0) nums[i++] = n;
    }
    while(i < nums.length) nums[i++] = 0;  //set values to zero for remainintg ith element
    return nums;
}
}