class Solution {
    int ans = 0;
    public void solve(int [] nums, int mask,List<Integer> arr){
        if(arr.size()==nums.length){
            ans= ans+1;
            return;
        }
        for(int i =0; i<nums.length; i++){
 if (i > 0 && nums[i] == nums[i - 1] && (mask & (1 << (i - 1))) == 0) continue;
            if((mask & (1 << i)) == 0){
             int num = arr.get(arr.size()-1) + nums[i];
              long sqroot = (long) Math.sqrt(num);
              if(sqroot*sqroot == (long)num){
                arr.add(nums[i]);
                int newmask = mask|1<<i;
                solve(nums,newmask,arr);
                arr.remove(arr.size() - 1);
              }
            }
              
            }
            return;
        }
    
    public int numSquarefulPerms(int[] nums) {
    Arrays.sort(nums);
    for(int i =0; i<nums.length; i++){
         if (i > 0 && nums[i] == nums[i - 1]) continue;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[i]);
        int mask = 0;
        mask = mask | 1<<i;
        solve(nums,mask,arr);
    }
    return ans;
    }
}