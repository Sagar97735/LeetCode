class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
    int [] ans = new int[2*n];
    for(int i =0; i<ans.length; i++){
        if(i<nums.length){
            ans[i] = nums[i];
        }
        else{
            ans[i] = nums[i-n];
        }
    }
      Stack<Integer> s1 = new Stack<>();
      Arrays.fill(nums,-1);
      for(int i = ans.length-1; i>=0; i--){
        while(!s1.isEmpty() && s1.peek()<=ans[i]){
              s1.pop();
        }
        if(s1.isEmpty()){
            s1.push(ans[i]);
        }
        else{
            if(i>=nums.length){
                nums[i-n] = s1.peek();
                s1.push(ans[i]);
            }
            else{
                nums[i] = s1.peek();
                s1.push(ans[i]);
            }
        }
      }
      return nums;
    }
}