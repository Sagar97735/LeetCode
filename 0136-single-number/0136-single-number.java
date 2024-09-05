class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
      int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j =0;j<nums.length;j++){
                if(i!=j && nums[i]==nums[j]){
                   count++;
                }
                
            }
            int ans = count;
                count = 0;
                if(ans == 0){
                    result = nums[i];
                }
        }
        return result;
    }
}