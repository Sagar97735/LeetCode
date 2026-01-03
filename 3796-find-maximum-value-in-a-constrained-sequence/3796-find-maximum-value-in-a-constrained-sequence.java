class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int arr[] = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for(int ans[]: restrictions){
            arr[ans[0]] = Math.min(arr[ans[0]], ans[1]);
        }
        for(int i=0; i<n-1; i++){
            if(arr[i] != Long.MAX_VALUE){
                arr[i+1] = Math.min(arr[i+1], arr[i] + diff[i]);
            }        
        }
        for(int i=n-2; i>=0; i--){
            if(arr[i+1] != Long.MAX_VALUE){
                arr[i] = Math.min(arr[i], arr[i+1] + diff[i]);
            }
        }
        int ans = 0;
        for(int val: arr){
            ans = Math.max(ans, val);
        }
        return ans;
    }
}