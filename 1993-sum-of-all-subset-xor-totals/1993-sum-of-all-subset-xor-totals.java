class Solution {
    public int isSolve(int index, int xor, int[] nums){
        if(index == nums.length){
            return xor;
        }

        // Include current element
        int include = isSolve(index + 1, xor ^ nums[index], nums);

        // Exclude current element
        int exclude = isSolve(index + 1, xor, nums);

        return include + exclude;
    }

    public int subsetXORSum(int[] nums) {
        return isSolve(0, 0, nums);
    }
}
