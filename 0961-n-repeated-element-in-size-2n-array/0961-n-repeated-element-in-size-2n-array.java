class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        Set<Integer> h1 = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            if(h1.contains(nums[i])){
                return nums[i];
            }
            h1.add(nums[i]);
        }
        return -1;
    }
}