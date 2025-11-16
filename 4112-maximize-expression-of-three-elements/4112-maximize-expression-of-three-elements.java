class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int a = Integer.MIN_VALUE;;
        int b = Integer.MIN_VALUE;;
        int c = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
          c = Math.min(c,nums[i]);
          if(nums[i]>a){
             b = a;
             a = Math.max(nums[i],a);
          }
          else if(nums[i]>b){
             b = Math.max(nums[i],b);
          }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        return a+b-c;
    }
}