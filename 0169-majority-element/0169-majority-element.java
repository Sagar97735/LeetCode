class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        int count = 0;
        int n = nums.length/2;
        int ans = 0;
        for(int i =0; i<nums.length; i++){
              if(h1.containsKey(nums[i])){
                int a = h1.get(nums[i]);
                h1.replace(nums[i],a+1);
              }
              else{
                h1.put(nums[i],1);
              }
              int b = h1.get(nums[i]);
              if(b>n){
                ans= nums[i];
              }
        }
        return ans;
    }
}