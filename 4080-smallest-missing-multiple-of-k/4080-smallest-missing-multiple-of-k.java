class Solution {
    public int missingMultiple(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int j = 1;
      for(int i =0; i<nums.length; i++){
        if(nums[i]== (k*j)){
            j++;
        }
        else if(nums[i]> (k*j)){
            return k*j;
        }
      }
      return k*j;
    }
}