class Solution {
    public boolean solve(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            while (start < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while (start < end && nums[end] == nums[end - 1]) {
                end--;
            }

            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] <= nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
        }
        int pivot = end;
        System.out.print(end);
        if (solve(nums, 0, pivot - 1, target)) {
            return true;
        }
        return solve(nums, pivot, nums.length - 1, target);

    }
}
