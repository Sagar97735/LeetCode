class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Track the minimum price so far
        int maxProfit = 0;  // Track maximum profit found

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;  // Update min price if a lower value is found
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);  // Update max profit
            }
        }
        return maxProfit;
    }
}
