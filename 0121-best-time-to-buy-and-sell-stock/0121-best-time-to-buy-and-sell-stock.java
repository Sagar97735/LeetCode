class Solution {
    public int maxProfit(int[] prices) {
        int [] minm = new int[prices.length];
        int ans = 0;
        int maxm =0;
        Arrays.fill(minm,Integer.MAX_VALUE);
        for(int i =0; i<prices.length; i++){
            minm[i] = Math.min(minm[i],prices[i]);
          
        }
         for(int i = prices.length-1; i>=0; i--){
           maxm = Math.max(maxm,prices[i]);
           ans = Math.max(maxm-minm[i],ans);
          
        }
      
        return ans;
    }
}