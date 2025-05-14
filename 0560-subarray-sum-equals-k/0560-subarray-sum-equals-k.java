class Solution {
    public int subarraySum(int[] nums, int k) {
        int i =0;
        int j =0;
        int sum =0;
        int cnt =0;
        while(i<nums.length){
          sum+=nums[j];
          if(sum==k){
            cnt++;
          }
              j++;
          
          if(j==nums.length){
            i++;
            j=i;
            sum=0;
          }
        }
         return cnt;
    }
}