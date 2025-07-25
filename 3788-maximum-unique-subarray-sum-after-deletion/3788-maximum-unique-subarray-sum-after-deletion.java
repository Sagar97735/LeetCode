class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        HashSet<Integer> h1 = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            if(nums[i]>0){
                h1.add(nums[i]);
            }
            max = Math.max(max,nums[i]);
        }
        for(int num: h1){
            sum+=num;
        }
        if(sum==0){
            return max;
        }
        return sum;
    }
}