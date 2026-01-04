class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int i =0; i<nums.length; i++){
           int val = (int) Math.sqrt(nums[i]);
            int cnt = 0;
            int sum = 0;
            for(int j =1; j<=val; j++){
             if(nums[i]%j==0){
                cnt+=1;
                sum+=j;
                if(nums[i]/j !=j){
                     sum+=(nums[i]/j);
                     cnt+=1;
                }
             }
            }
            if(cnt==4){
                ans+=sum;
            }
        }
        return ans;
    }
}