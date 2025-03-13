class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // If array has 2 or fewer elements, no change needed

        int i = 1; // Position for the next valid element
        int count = 1; // Count occurrences of current number

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                count++; // Increment count if duplicate is found
            } else {
                count = 1; // Reset count for new number
            }

            if (count <= 2) {
                nums[i] = nums[j]; // Place the valid number in position i
                i++; // Move the pointer forward
            }
        }

        return i; // New length of modified array
    }
}
