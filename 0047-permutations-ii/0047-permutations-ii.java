class Solution {
    private HashSet<List<Integer>> result = new HashSet<>();
    private int n;
    
    public void solve(int idx, List<Integer> nums) {
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
    public List<List<Integer>> permuteUnique(int[] nums) {
          n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        
        solve(0, numList);
        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;
    }
}