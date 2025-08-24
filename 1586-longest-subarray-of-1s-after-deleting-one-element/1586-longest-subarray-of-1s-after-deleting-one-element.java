class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // agar 1 se zyada zero ho gaye to shrink karo
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // window ka length calculate
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // ek element delete karna mandatory hai
        return maxLen - 1;
    }
}
