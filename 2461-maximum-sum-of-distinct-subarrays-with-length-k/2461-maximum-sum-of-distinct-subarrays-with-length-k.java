class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0, ans = 0;
        int i = 0, j = 0;

        while (j < nums.length) {

            // Remove duplicates by shrinking from left
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // Now nums[j] is unique
            set.add(nums[j]);
            sum += nums[j];

            // If window size becomes > k → shrink
            if (j - i + 1 > k) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // When window size is exactly k → consider answer
            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
            }

            j++;
        }

        return ans;
    }
}
