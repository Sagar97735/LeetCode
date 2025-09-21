class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long ans = 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i =0; i<nums.length; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        System.out.println(max);
        System.out.println(min);

        ans = max - min;
        ans*=k;
        return ans;
    }
}