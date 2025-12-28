class Solution {
    public long maximumScore(int[] nums) {
        long [] arr = new long[nums.length];
        arr[0] = nums[0];
        for(int i =1; i<arr.length; i++){
            arr[i] = nums[i] + arr[i-1];
        }
        long ans = Long.MIN_VALUE;
        int [] min = new int[nums.length];
        int minm = Integer.MAX_VALUE;
        for(int i = nums.length-2; i>=0; i--){
            minm = Math.min(minm,nums[i+1]);
            min[i] = minm;
            ans = Math.max(ans,arr[i]-min[i]);
        }
       

       return ans;
    }
}