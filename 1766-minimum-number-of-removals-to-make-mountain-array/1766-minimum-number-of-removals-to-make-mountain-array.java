class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];
        Arrays.fill(prefix,1);
         Arrays.fill(suffix,1);
        for(int i =0; i<nums.length; i++){
            for(int j =0; j<i; j++){
                if(nums[j]<nums[i]){
                    prefix[i] = Math.max(prefix[i],1+prefix[j]);
                }
            }
            System.out.print(prefix[i]);
        }
        System.out.println();
        for(int i = nums.length-1; i>=0; i--){
            for(int j =nums.length-1; j> i; j--){
                if(nums[i] > nums[j]){
                    suffix[i] = Math.max(suffix[i],1+suffix[j]);
                }
            }
            System.out.print(suffix[i]);
        }
        int max =0;
            for(int i =1; i<prefix.length-1; i++){
                if(prefix[i]>1 && suffix[i]>1)
              max = Math.max(max , prefix[i] + suffix[i]);
            }
            max = max-1;
            return nums.length-max;
    }
}