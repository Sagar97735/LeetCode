class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> h1 = new HashSet<>();
        HashMap<Integer,Integer> h2 = new HashMap<>();
        for(int i =0;i<nums.length; i++){
            h1.add(nums[i]);
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j<nums.length){
         h2.put(nums[j],h2.getOrDefault(nums[j],0)+1);
         while(h2.size()==h1.size()){
          ans+=(nums.length-j);
          h2.put(nums[i],h2.get(nums[i])-1);
           if (h2.get(nums[i]) == 0) {
                    h2.remove(nums[i]);
                }
                i++;
         }
         j++;
        }
        return ans;
    }
}