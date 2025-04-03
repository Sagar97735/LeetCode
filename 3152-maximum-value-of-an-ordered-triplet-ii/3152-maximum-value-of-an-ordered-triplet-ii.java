class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int[] maxRight = new int[n]; 
        maxRight[n - 1] = nums[n - 1];

        // Compute maxRight array
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int maxLeft = nums[0];
        long maxTripletValue = 0;

        // Compute the maximum triplet value
        for (int i = 1; i < n - 1; i++) {
            maxLeft = Math.max(maxLeft, nums[i - 1]);
            long tripletValue = (long)(maxLeft - nums[i]) * maxRight[i + 1];
            maxTripletValue = Math.max(maxTripletValue, tripletValue);
        }

        return maxTripletValue;
    }
}
