class Solution {
    public int solve(int [] nums,int idx){
        HashMap<Integer,Integer>h1 = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            h1.put(nums[i],0);
        }
        int size = h1.size();
        int cnt =0;
        int ans = 0;
        for(int i =idx; i<nums.length; i++){
            int curr = nums[i];
        if(h1.get(curr)==1){
            continue;
          }
        else if(h1.get(curr)==0){
            h1.put(curr,1);
            cnt++;
          }
        
        if(cnt==size){
          ans = nums.length-i;
          return ans;
        }
        }
        return ans;
    }
    public int countCompleteSubarrays(int[] nums) {
         int ans = 0;
         for(int i =0; i<nums.length; i++){
            int ans1 = solve(nums,i);
            if(ans1==0){
                break;
            }
            else{
                ans+=ans1;
            }
         }
         return ans;
    }
}