class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j];
            j++;

            while (sum >= target) {
                ans = Math.min(ans, j - i); // correct window size
                sum -= nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
