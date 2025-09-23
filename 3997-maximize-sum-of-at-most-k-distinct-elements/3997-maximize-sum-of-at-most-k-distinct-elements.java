class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =nums.length-1; i>=0; i--){
            if(!(arr.contains(nums[i]))&&arr.size()<k){
               arr.add(nums[i]);
            }
        }
        int [] ans = new int[arr.size()];
        for(int i =0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}