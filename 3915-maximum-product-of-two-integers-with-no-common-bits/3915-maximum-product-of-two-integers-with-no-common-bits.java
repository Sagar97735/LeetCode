class Solution {
    public long maxProduct(int[] nums) {
        // find the max val from the array
        int maxVal = 0;
        for(int num:nums) 
            maxVal = Math.max(maxVal, num);
        
        // find the maxBits reqd to represent the max_val and the mask we need. The mask is actually all maxBits no.of bits set to 1 
        int maxBits = (int)(Math.log(maxVal)/Math.log(2)) + 1, mask = (1<<maxBits) - 1;

        // create the submask dp array which will always contain the maxm value of nums satisfying the bit pattern for the mask
        int maskDp[] = new int[mask+1];

        // For ex: we have 34 in our array, we need to initially set dp[34] to 34
        for(int num:nums) 
            maskDp[num] = num;

        // Actual logic
        for(int i=0; i<maxBits; ++i) {
            for(int j=1, tempMask = (1<<i); j<=mask; ++j) {
                if((j & tempMask) != 0) {   
                    // If our submask is 105, then this would be executed for dp[104, 97,73,41] and dp[105]
                    maskDp[j] = Math.max(maskDp[j], maskDp[tempMask ^ j]);
                }
            }
        }

        // finding the maxm pdt pair
        long maxPdt = 0;
        for(int num:nums) 
            maxPdt = Math.max(maxPdt, (long)num * maskDp[num ^ mask]);

        return maxPdt;
    }
}