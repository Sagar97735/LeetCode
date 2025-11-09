class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> h1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = h1.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            h1.put(nums[i], list);
        }
      for(Map.Entry <Integer,List<Integer>> en : h1.entrySet()){
        int key = en.getKey();
        List<Integer> arr = en.getValue();
        if(arr.size()>=3){
            int i = 0;
            while(i<arr.size()-2){
           int val = Math.abs(arr.get(i)-arr.get(i+1)) + Math.abs(arr.get(i+1)-arr.get(i+2)) + Math.abs(arr.get(i+2)-arr.get(i));
            ans = Math.min(ans,val);
            i++;
            }
        }
      }
      if(ans>=99999){
        return -1;
      }
      return ans;
    }
}