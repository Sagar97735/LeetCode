class Solution {
    public boolean partitionArray(int[] nums, int k) {
       int n = nums.length; 
       int groups = n/k;
       if(n%k!=0){
        return false;
       }
       HashMap<Integer, Integer> h1 = new HashMap<>();
       for(int i = 0; i<nums.length; i++){
        h1.put(nums[i],h1.getOrDefault(nums[i],0)+1);
         if(h1.get(nums[i])>groups){
            return false;
        }
       }
      return true;
    }
}