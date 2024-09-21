class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans1 = new int[queries.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] ^ arr[i - 1];
        }
        for (int j = 0; j < queries.length; j++) {
            int a = queries[j][0];
            int b = queries[j][1];
            if (a > 0) {
                ans1[j] = arr[a - 1] ^ arr[b];
            } else {
                ans1[j] = arr[b];
            }
        }
        return ans1;
    }
}