class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            if(h1.containsKey(nums[i])){
               h1.put(nums[i],2);
            }
            else{
                h1.put(nums[i],1);
            }
        }
        for(int i =0;i<nums.length; i++){
            if(h1.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }
}