class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the target is at the mid index
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (nums[start] <= nums[mid]) {
                // Left part is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    // Target is in the left part
                    end = mid - 1;
                } else {
                    // Target is in the right part
                    start = mid + 1;
                }
            } else {
                // Right part is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    // Target is in the right part
                    start = mid + 1;
                } else {
                    // Target is in the left part
                    end = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}
