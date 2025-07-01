class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Number of missing elements before index mid = arr[mid] - (mid + 1)
            if (arr[mid] - (mid + 1) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // The k-th missing number is start + k
        return start + k;
    }
}
