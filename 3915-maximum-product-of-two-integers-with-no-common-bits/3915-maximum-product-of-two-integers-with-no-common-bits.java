class Solution {
    public long maxProduct(int[] nums) {
        // Step 1: Find the maximum value in nums
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

         int totalBits = Integer.toBinaryString(maxValue).length();

        // Create a mask with all totalBits set to 1
        // Example: if totalBits = 5 → mask = 11111 (binary) = 31
        int fullMask = (1 << totalBits) - 1;

        // Step 3: DP array where dp[mask] stores the maximum number in nums
        // that has a bit pattern matching 'mask' (or its submasks later).
        int[] dp = new int[fullMask + 1];

        // Initialize dp with the exact numbers present in nums
        for (int num : nums) {
            dp[num] = Math.max(dp[num], num);
        }

        // Step 4: Fill dp so that dp[mask] contains the maximum value
        // among all numbers that are submasks of 'mask'
        for (int bit = 0; bit < totalBits; bit++) {
            int bitMask = 1 << bit;
            for (int mask = 1; mask <= fullMask; mask++) {
                if ((mask & bitMask) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ bitMask]);
                }
            }
        }

        // Step 5: Find the maximum product
        long maxProduct = 0;
        for (int num : nums) {
            // num ^ fullMask = complement bits (within totalBits)
            maxProduct = Math.max(maxProduct, (long) num * dp[num ^ fullMask]);
        }

        return maxProduct;
    }
}
