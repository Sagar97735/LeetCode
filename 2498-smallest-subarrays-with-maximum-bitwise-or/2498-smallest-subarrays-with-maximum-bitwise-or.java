class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] lastSeen = new int[32];  // Last seen index for each bit (0 to 31)

        // Initialize: -1 means bit not seen yet
        for (int b = 0; b < 32; b++) {
            lastSeen[b] = -1;
        }

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Update lastSeen for all bits set in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastSeen[b] = i;
                }
            }

            // Find farthest index needed to include all important bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                if (lastSeen[b] != -1) {
                    maxReach = Math.max(maxReach, lastSeen[b]);
                }
            }

            ans[i] = maxReach - i + 1;
        }

        return ans;
    }
}
