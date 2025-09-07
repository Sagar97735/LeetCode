class Solution {
    public long bowlSubarrays(int[] nums) {
        long cnt = 0;
        Stack<Integer> s1 = new Stack<>();

        for (int r = 0; r < nums.length; r++) {
            while (!s1.isEmpty() && nums[s1.peek()] <= nums[r]) {
                int l = s1.pop();
                if (r - l + 1 >= 3) {
                    cnt++;
                }
            }
            if (!s1.isEmpty() && r - s1.peek() + 1 >= 3) {
                cnt++;
            }
            s1.push(r);
        }

        return cnt;
    }
}