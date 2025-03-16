class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;
        int[] dp1 = new int[n]; // Exclude last house
        int[] dp2 = new int[n]; // Exclude first house

        // Case 1: Rob houses from index 0 to n-2 (excluding last house)
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        // Case 2: Rob houses from index 1 to n-1 (excluding first house)
        dp2[0] = 0; // Start from 0 since first house is skipped
        dp2[1] = nums[1];
        for (int i = 2; i < n; i++) { // Fix loop to start at 2, not 3
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
