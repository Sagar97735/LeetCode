class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for(int i =0; i<candies.length; i++){
            max = Math.max(max,candies[i]);
        }
        int start = 1;
        int end = max;
        while(start <= end){
            int mid = (start+end)/2;
            if(isAllocate(candies, k, mid)){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return end;
    }
    public boolean isAllocate(int arr[], long k, int n){
        long cnt = 0;
        for(int i=0; i<arr.length; i++){
            int p = arr[i];
            p = p/n;
            cnt += p;
            if(cnt >= k){
                return true;
            }
        }
        return false;
    }
}