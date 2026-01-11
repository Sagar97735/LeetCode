class Solution {
    public int centeredSubarrays(int[] nums) {
        int cnt = 0;
        for(int i =0; i<nums.length; i++){
            HashSet<Integer> h1 = new HashSet<>();
            int sum = 0;
            for(int j =i; j<nums.length; j++){
               h1.add(nums[j]);
               sum+=nums[j];
               if(h1.contains(sum)){
                 cnt++;
               }
            }
        }
        return cnt;
    }
}