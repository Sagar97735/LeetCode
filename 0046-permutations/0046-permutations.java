// import java.util.*;

// class Solution {
//     public static void solve(List<List<Integer>> arr, List<Integer> arr1, int[] nums, boolean[] used) {
//         if (arr1.size() == nums.length) {
//             arr.add(new ArrayList<>(arr1));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) { // Iterate from 0 to consider all numbers
//             if (!used[i]) { // Ensure each number is used only once per permutation
//                 used[i] = true;
//                 arr1.add(nums[i]);

//                 solve(arr, arr1, nums, used); // Recursive call

//                 // Backtrack
//                 arr1.remove(arr1.size() - 1);
//                 used[i] = false;
//             }
//         }
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<Integer> arr1 = new ArrayList<>();
//         List<List<Integer>> arr = new ArrayList<>();
//         boolean[] used = new boolean[nums.length]; // Track used numbers

//         solve(arr, arr1, nums, used);
//         return arr;
//     }
// }

//Approach2 By swapping elements if not understand see codewithmik

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int n;
    
    private void solve(int idx, List<Integer> nums) {
        if (idx == n) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i = idx; i < n; i++) {
            Collections.swap(nums, i, idx);
            solve(idx + 1, nums);
            Collections.swap(nums, i, idx);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        solve(0, numList);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = sol.permute(nums);
        System.out.println(permutations);
    }
}
