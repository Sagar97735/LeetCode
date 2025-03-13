class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int j = 0;
        if(nums.length==1 || k==nums.length){
            return;
        }
        if(k>nums.length){
            k = k%nums.length;
        }
        for(int i = nums.length-k; i<nums.length; i++){
            arr[j] = nums[i];
            j++;
        }
        int a =0;
       for(int i = k; i<nums.length; i++){
        arr[i] = nums[a];
        a++;
       }
       for(int i =0; i<nums.length; i++){
          nums[i] = arr[i];
       }
        return ;
    }
}