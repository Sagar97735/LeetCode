class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> h1 = new HashSet<>();
        int ans = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > 0) {
                h1.add(num);
            } else {
                max = Math.max(max, num);
            }
        }

        for (int num : h1) {
            ans += num;
        }
        if(ans==0){
            return max;
        }
        return ans;
        
    }
}