class Solution {
    public boolean solve(int[] candies, long candy, long k){
        long total = 0;
        for(int c : candies){
            total += c / candy;
            if(total >= k) return true;
        }
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int c : candies) sum += c;
        if(sum < k) return 0;

        long low = 1;
        long high = (sum / k);  // max candies child can get
        long ans = 0;

        while(low <= high){
            long mid = low + (high - low) / 2;

            if(solve(candies, mid, k)){
                ans = mid;
                low = mid + 1;   // go right
            } else {
                high = mid - 1;  // go left
            }
        }

        return (int)ans;
    }
}
