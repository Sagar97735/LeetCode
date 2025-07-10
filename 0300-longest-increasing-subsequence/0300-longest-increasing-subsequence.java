class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] arr = new int[nums.length];
        Arrays.fill(arr,1);
        for(int i =0; i<nums.length; i++){
            for(int j =0; j<i; j++){
              if(nums[j]<nums[i]){
                arr[i] = Math.max(arr[j]+1,arr[i]);
              }
            }
        }
        int max = 0;
        for(int i =0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}