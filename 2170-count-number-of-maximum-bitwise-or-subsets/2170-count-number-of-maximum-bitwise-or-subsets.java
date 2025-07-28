class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        count = 0;
        
        // Step 1: Find max OR
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Start backtracking
        dfs(nums, 0, 0);

        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        // Include current number
        dfs(nums, index + 1, currentOr | nums[index]);

        // Exclude current number
        dfs(nums, index + 1, currentOr);
    }
}
