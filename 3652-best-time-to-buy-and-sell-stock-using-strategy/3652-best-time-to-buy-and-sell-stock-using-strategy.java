class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefixOld = new long[n + 1];   // sum of strategy[i]*prices[i]
        long[] prefixPrice = new long[n + 1]; // sum of prices[i]

        long original = 0;
        for (int i = 0; i < n; i++) {
            long old = 1L * strategy[i] * prices[i];
            prefixOld[i + 1] = prefixOld[i] + old;
            prefixPrice[i + 1] = prefixPrice[i] + prices[i];
            original += old;
        }

        long bestDelta = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            // first half
            long oldFirst = prefixOld[mid] - prefixOld[l];
            long newFirst = 0; // all forced to hold
            // second half
            long oldSecond = prefixOld[r] - prefixOld[mid];
            long newSecond = prefixPrice[r] - prefixPrice[mid]; // all forced to sell

            long delta = (newFirst - oldFirst) + (newSecond - oldSecond);
            bestDelta = Math.max(bestDelta, delta);
        }

        return original + bestDelta;
    }
}