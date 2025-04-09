class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> h1 = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            if(nums[i]<k){
                return -1;
            }
         else if (nums[i]>k)h1.add(nums[i]);
        }
        return h1.size();
    }
}