class Solution {
    public int longestBalanced(int[] nums) {
         int ans = 0;  
        for(int i =0; i<nums.length; i++){
             int odd =0;
             int even =0;
          HashSet<Integer> h1 = new HashSet<>();
            for(int j =i; j<nums.length; j++){
                if(!h1.contains(nums[j]) && nums[j]%2==0){
                    h1.add(nums[j]);
                    even++;
                }
                else if(!h1.contains(nums[j])){
                    h1.add(nums[j]);
                    odd++;
                }
                
                if(odd==even){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}