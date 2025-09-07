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

//---------------------------------------------Brute Force---------------------------------------------------------------------
class Solution {
    public long bowlSubarrays(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            long min = nums[i];
            long max = 0;
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 >= 3) {
                    max = Math.max(max, nums[j - 1]);
                    min = Math.min(nums[i], nums[j]);
                    if (min > max) {
                        cnt++;
                    }
                }
            }

        }
        return cnt;
    }
}
