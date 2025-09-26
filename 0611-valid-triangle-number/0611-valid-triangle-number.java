import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums); // sort the sides
        int n = nums.length;
        int cnt = 0;

        for (int k = n - 1; k >= 2; k--) {  // fix the largest side
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    cnt += (j - i);  // all pairs between i..j-1 will also form triangle
                    j--;
                } else {
                    i++;
                }
            }
        }

        return cnt;
    }
}
