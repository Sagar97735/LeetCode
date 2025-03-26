import java.util.*;

class Solution {
    public static void solve(List<List<Integer>> arr, List<Integer> arr1, int[] nums, boolean[] used) {
        if (arr1.size() == nums.length) {
            arr.add(new ArrayList<>(arr1));
            return;
        }

        for (int i = 0; i < nums.length; i++) { // Iterate from 0 to consider all numbers
            if (!used[i]) { // Ensure each number is used only once per permutation
                used[i] = true;
                arr1.add(nums[i]);

                solve(arr, arr1, nums, used); // Recursive call

                // Backtrack
                arr1.remove(arr1.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // Track used numbers

        solve(arr, arr1, nums, used);
        return arr;
    }
}
