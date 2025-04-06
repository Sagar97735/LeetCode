class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        Arrays.fill(dp, 1);
        
        int maxIdx = 0;
        
        for(int i=0; i<n; i++){
            hash[i] = i; // Initially pointing to itself
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            
            if(dp[i] > dp[maxIdx]){
                maxIdx = i;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[maxIdx]);
        
        while(hash[maxIdx] != maxIdx){
            maxIdx = hash[maxIdx];
            ans.add(nums[maxIdx]);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
