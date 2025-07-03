class Solution {
    public void solve(int[] nums,int [] ans){
        Stack<Integer> s1 = new Stack<>();
        for(int i = nums.length-1; i>=0; i--){
          while(!s1.isEmpty() && s1.peek()<=nums[i]){
            s1.pop();
          }
          if(s1.isEmpty()){
            s1.push(nums[i]);
            ans[i] = -1;
          }
          else{
            ans[i]= s1.peek();
            s1.push(nums[i]);
          }
    }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s1 = new Stack<>();
        int[] ans = new int [nums2.length];
        int [] ans1 = new int[nums1.length];
        solve(nums2,ans);
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int i =0; i<nums2.length; i++){
           h1.put(nums2[i],ans[i]);
        }
        for(int i =0; i<nums1.length; i++){
           ans1[i] = h1.get(nums1[i]);
        }
        return ans1;
    }
}