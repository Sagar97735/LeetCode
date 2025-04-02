class Solution {
    public long maximumTripletValue(int[] nums) {
    long ans = 0;
     if(nums.length<3){
        return ans;
      }
      int k = nums.length-1;
       while(k>=2){
        int i = 0;
        int j = i+1;
        long max = Integer.MIN_VALUE;
        while(i<k && i<j){
          if(j==k){
            i++;
            j= i+1;
          }
          else{
            max = Math.max(max,nums[i]-nums[j]);
            j++;
          }
        }
        ans = Math.max(max*nums[k],ans);
        k--;
       }
        
        return ans;
    }
}