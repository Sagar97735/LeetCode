class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [] suffix = new int [prices.length];
        suffix[n-1] = 0;
        int max = 0;
        for(int i = prices.length-2; i>=0; i--){
             suffix[i] = Math.max(suffix[i+1],prices[i+1]);
        }
        for(int i =0; i<prices.length; i++){
            max = Math.max(max,suffix[i]-prices[i]);
        }
        return max;
    }
}