class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        long end = (long) 1e14; // large enough upper bound
        long ans = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long trips = 0;
            for (int t : time) {
                trips += mid / t;
                if (trips >= totalTrips) break; // avoid overflow
            }

            if (trips >= totalTrips) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
