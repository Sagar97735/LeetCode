class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        int max = 1;
        int ans = 0;
        for(int i =0; i<nums.length; i++){
            if(h1.containsKey(nums[i])){
                int freq = h1.getOrDefault(nums[i],0)+1;
                max = Math.max(max,freq);
                h1.put(nums[i],freq);
            }
            else{
                  h1.put(nums[i],1);
            }
            
        }
        for(int i =0; i<nums.length;i++){
          if(h1.get(nums[i])==max){
            ans+=1;
          }
        }
        return ans;
    }
}