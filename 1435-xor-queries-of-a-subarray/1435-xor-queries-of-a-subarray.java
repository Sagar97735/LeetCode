class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
    int [] ans = new int [queries.length];
    for(int i =0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int ans1 = 0;
            for(int j = a; j<=b; j++){
                ans1 = ans1^arr[j];
            }
        ans[i] = ans1;
    }
    return ans;
    }
}