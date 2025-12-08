class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            h1.put(nums[i],h1.getOrDefault(nums[i],0)+1);
            sum += nums[i];
        }
        if (h1.size() == k) {
            ans = Math.max(ans, sum);
        }
        int i = 0;
        int j = k;
        while (j < nums.length) {
            h1.put(nums[j],h1.getOrDefault(nums[j],0)+1);
            h1.put(nums[i],h1.getOrDefault(nums[i],0)-1);
            sum += nums[j];
            sum -= nums[i];
            if(h1.get(nums[i])==0){
                h1.remove(nums[i]);
            }
            if (j - i == k && h1.size() == k) {
                ans = Math.max(ans, sum);
            }
            j++;
            i++;

        }
        return ans;
    }
}