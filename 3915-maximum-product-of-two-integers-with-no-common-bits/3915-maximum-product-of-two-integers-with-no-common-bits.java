class Solution {
    public long maxProduct(int[] nums) {
        // Step 1: Find max number from nums
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        // Step 2: Find how many bits we need
        int totalBits = Integer.toBinaryString(maxNum).length();

        // Step 3: dp[mask] = maximum number which has bits inside 'mask'
        int size = 1 << totalBits; // 2^totalBits
        int[] dp = new int[size];

        // Step 4: Fill dp with given nums
        for (int num : nums) {
            dp[num] = num;
        }

        // Step 5: Propagate values to subsets
        for (int bit = 0; bit < totalBits; bit++) {
            for (int bitmask = 0; bitmask < size; bitmask++) {
                if ((bitmask & (1 << bit)) != 0) {
                    int smallerMask = bitmask ^ (1 << bit);
                    dp[bitmask] = Math.max(dp[bitmask], dp[smallerMask]);
                }
            }
        }

        // Step 6: Find max product
        long bestProduct = 0;
        for (int num : nums) {
            int oppositeMask = (~num) & (size - 1);
            bestProduct = Math.max(bestProduct, (long) num * dp[oppositeMask]);
        }

        return bestProduct;
    }
}
