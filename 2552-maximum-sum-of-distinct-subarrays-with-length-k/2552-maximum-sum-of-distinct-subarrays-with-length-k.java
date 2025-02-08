class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> h1 = new HashSet<>();
        int j = 0;
        int i = 0;
        long sum = 0;
        long ans = 0;
        while(j<nums.length){
            if(h1.contains(nums[j])){
               while (h1.contains(nums[j])) {
                sum -= nums[i];
                h1.remove(nums[i]);
                i++;//fint new value of i
            }
            }
                h1.add(nums[j]);
                sum+=nums[j];
                 if(h1.size() == k){
                    ans = Math.max(ans,sum);
                   h1.remove(nums[i]);
                    sum -= nums[i];
                    i++;
                  }  
            
            j++;
        }
     return ans;
    }
}
